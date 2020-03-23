package com.user.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.user.base.comm.CodeMsg;
import com.user.base.comm.CommonPage;
import com.user.base.comm.RequestBean;
import com.user.base.comm.ResponseBean;
import com.user.base.config.RedisUtil;
import com.user.base.dao.UserRoleMapper;
import com.user.base.entity.model.Area;
import com.user.base.entity.model.Role;
import com.user.base.entity.model.User;
import com.user.base.entity.model.UserRole;
import com.user.base.service.RoleService;
import com.user.base.service.UserService;
import com.user.app.exception.BuExceptionEnum;
import com.user.app.exception.BusinessException;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 系统平台用户管理
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleMapper userRoleMapper;


    @RequestMapping(value = "/userList")
    public String userList(User user, ModelMap modelMap) {
        PageInfo<User> pageInfo = userService.findPage(user);
        List<User> list = pageInfo.getList();
        CommonPage page = CommonPage.setPageModel(pageInfo);
        modelMap.put("userList",list);
        modelMap.put("page",page);

        return "rbac/user/user_list";
    }

    @RequestMapping(value = "/toAddPage")
    public String toAddPage(HttpServletRequest request, ModelMap modelMap){
        if(request.getParameter("id")!=null && !request.getParameter("id").equals("")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            modelMap.put("user",userService.queryByPrimary(id));
        }else {
            modelMap.put("user",new User());
        }
        return "rbac/user/user_edit";
    }


    @RequestMapping(value = "/doSaveUser")
    @ResponseBody
    public CodeMsg doSaveUser(@RequestBody User user){
        //添加
        if(userService.saveUser(user)==1){
            return new CodeMsg("200","添加成功");
        }
        return new CodeMsg("-1","系统错误");

    }

    @RequestMapping(value = "/doUpdateUser")
    @ResponseBody
    public CodeMsg doUpdateUser(@RequestBody User user){
        if(userService.updateBySelective(user)==1){
            return new CodeMsg("200","修改成功");
        }
        return new CodeMsg("-1","系统错误");
    }

    @RequestMapping(value = "/toAddRolePage")
    public String toAddRolePage(HttpServletRequest request, ModelMap modelMap){
        if(request.getParameter("id")!=null && !request.getParameter("id").equals("")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            User user = userService.queryByPrimary(id);
            modelMap.put("user",user);
            List<Role> allRoles = roleService.queryAllRols();
            List<Role>  roleList = userRoleMapper.queryRolesByUserId(id);
            List<Integer> roleIds = new ArrayList<>();
            user.setRoleIds(roleIds);
            for(Role role:roleList){
                roleIds.add(role.getId());
            }
            modelMap.put("roleList",allRoles);
        }else {
            modelMap.put("user",new User());
        }
        return "rbac/user/user_role_edit";
    }

    @RequestMapping(value = "/doSaveUserRole")
    @ResponseBody
    public CodeMsg doSaveUserRole(@RequestBody User user,HttpServletRequest request){

        //把旧的数据删除
        UserRole userRole = new UserRole();
        userRole.setSysUserId(user.getId());
        userRoleMapper.deleteByParams(userRole);
        //添加新的数据
        List<UserRole> list = new ArrayList<>();
        if(user.getRoleIds().size()<=0){
            String str = request.getParameter("checkRoleId");
            Integer roleId = Integer.valueOf(str);
            UserRole userRole1 = new UserRole();
            userRole1.setSysUserId(user.getId());
            userRole1.setSysRoleId(roleId);
            list.add(userRole1);
        }else {
            for (Integer roleId : user.getRoleIds()) {
                UserRole userRole1 = new UserRole();
                userRole1.setSysUserId(user.getId());
                userRole1.setSysRoleId(roleId);
                list.add(userRole1);
            }
        }
        if(list.size()>0) {
            Integer i = userRoleMapper.insertUserRoles(list);
            return new CodeMsg("200", "角色设置成功");
        }
        return new CodeMsg("200", "角色设置成功");

    }




    @RequestMapping(value = "findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户分页列表")
    @ResponseBody
    public ResponseBean<PageInfo<User>> findPage(@RequestBody RequestBean<User> requestBean){
        User user = requestBean.getData();
        return ResponseBean.success(userService.findPage(user));
    }



    @RequestMapping(value = "testPage",method = RequestMethod.GET)
    @ApiOperation(value = "test分页列表")
    @ResponseBody
    public String testPage(Model model){
        model.addAttribute("","");
        return "rbac/role_list";
    }

    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户")
    @ResponseBody
    public ResponseBean<Integer> saveUser(@RequestBody @Valid User user){

        if(StringUtils.isBlank(user.getPassword()))
            user.setPassword("123456");
        Integer integer = userService.saveUser(user);
        return ResponseBean.success(CodeMsg.SUCCESS,integer);

    }

    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户")
    @ResponseBody
    public ResponseBean<Integer> updateUser(@RequestBody @Valid User user){

        Integer integer = userService.updateBySelective(user);
        return ResponseBean.success(CodeMsg.SUCCESS,integer);

    }

    @RequestMapping(value = "updateUserPass",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户密码")
    @ResponseBody
    public ResponseBean<Integer> updateUserPass(@RequestBody @Valid User user){

        Integer integer = userService.updateBySelective(user);
        return ResponseBean.success(CodeMsg.SUCCESS,integer);

    }

    @RequestMapping(value = "updateUserStatus",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户状态")
    @ResponseBody
    public ResponseBean<Integer> updateUserStatus(@RequestBody Map<String,Object> map){
        User user = new User();
        if(map.get("id") == null || Integer.valueOf(map.get("id").toString())==0 || map.get("status") ==null){
            throw new BusinessException(BuExceptionEnum.ILLEGAL_PARAMETERS);
        }
        user.setId(Integer.valueOf(map.get("id").toString()));
        user.setStatus(Integer.valueOf(map.get("status").toString()));
        Integer integer = userService.updateUserStatus(user);
        return ResponseBean.success(CodeMsg.SUCCESS,integer);

    }
    //给用户分配角色
    @RequestMapping(value = "updateUserRole",method = RequestMethod.POST)
    @ApiOperation(value = "给用户分配角色")
    @ResponseBody
    public ResponseBean<Integer> updateUserRole(@RequestBody @Valid RequestBean<Map<String,Object>> requestBean){
        Integer integer = userService.editUserRole(requestBean.getData());
        return ResponseBean.success(CodeMsg.SUCCESS,integer);

    }

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "doTest",method = RequestMethod.GET)
    @ApiOperation(value = "doTest")
    @ResponseBody
    public Object doTest(){
        JSONObject jsonObject = new JSONObject();
        redisUtil.set("password","12345678");
        redisUtil.set("name","abc");
        Object object = redisUtil.get("name");
        if(object!=null){
            System.out.println(object.toString());
        }
        Area area = new Area();
        area.setId(1);area.setName("北京");area.setPid(0);area.setType(1);
        redisUtil.set("beijing",area);
        Object object1 = redisUtil.get("beijing");
//        if(object1!=null && object1 instanceof  Area){
//            Area area1 = (Area)object1;
//            System.out.println("name:"+area1.getName());
//        }
        Area area0 = redisUtil.getForClass("beijing",Area.class);
        System.out.println("name:"+area0.getName());
        redisUtil.set("name","张三");
        Object object2 = redisUtil.get("name");
        System.out.println(object2.toString());

        Area area2 = new Area();
        area2.setId(2);area2.setName("深圳");area2.setPid(0);area2.setType(2);

        List<Area> areas = Arrays.asList(area,area2);
        redisUtil.set("areas",areas,1000);

        Object object3 = redisUtil.get("areas");
        if(object3!=null && object3 instanceof List){
            List<Area> list = (List<Area>) object3;
            System.out.println(list.get(1).getName());
        }
//        redisUtil.incr("codes",1l);
//        redisUtil.incr("codes",1l);
//        redisUtil.incr("codes",1l);
//        redisUtil.incr("codes",1l);
//        redisUtil.incr("codes",1l);

        System.out.println("num:"+redisUtil.decr("codes",1l));


        return jsonObject;

    }

    //高并发的解决方案
    @PostMapping(value = "/testRedis")
    public String testRedis(HttpServletRequest request) {
        // 通过用户ID和访问IP，处理重复请求
//        String key = userId + IPUtils.getIpAddr(request);
        String key = "";
        Object redisKey = redisUtil.get(key);
        System.out.println("redis值：" + redisKey);
        // redis中的key值存在则表示当前这次请求距离上一次请求不超过下面设置的三秒钟，直接返回即可
        if(redisKey != null){
            return "您的操作过快，请刷新重试";
        }
        Long count = redisUtil.incr(key, 1); // 设置递增因子
        System.out.println("递增的值" + count);
        redisUtil.expire(key,3);
        return "成功";
    }




}
