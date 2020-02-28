package com.user.base.controller;

import com.github.pagehelper.PageInfo;
import com.user.base.comm.CodeMsg;
import com.user.base.comm.CommonPage;
import com.user.base.comm.RequestBean;
import com.user.base.comm.ResponseBean;
import com.user.base.entity.model.User;
import com.user.base.service.UserService;
import com.user.common.exception.BuExceptionEnum;
import com.user.common.exception.BusinessException;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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


    @RequestMapping(value = "/userList")
    public String userList(User user, ModelMap modelMap) {
        PageInfo<User> pageInfo = userService.findPage(user);
        List<User> list = pageInfo.getList();
        CommonPage page = CommonPage.setPageModel(pageInfo);
        //modelMap.put("selectModel",params);
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
            return new CodeMsg("200","添加成功");
        }
        return new CodeMsg("-1","系统错误");
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




}