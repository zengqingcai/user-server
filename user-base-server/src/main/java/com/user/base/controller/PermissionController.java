package com.user.base.controller;

import com.github.pagehelper.PageInfo;
import com.user.base.common.CodeMsg;
import com.user.base.common.CommonPage;
import com.user.base.common.RequestBean;
import com.user.base.common.ResponseBean;
import com.user.base.config.RedisUtil;
import com.user.base.entity.dto.permission.PermissionListDTO;
import com.user.base.entity.model.Permission;
import com.user.base.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/1/7 8:56
 * @Version: 0.0.1
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @RequestMapping(value = "/permissionList")
    public String permissionList(Permission permission, ModelMap modelMap){
        if(permission.getCurrentPage()<= 0)
            permission.setCurrentPage(1);

        permission.setParentId(permission.getParentId()==null?0:permission.getParentId());
        PageInfo<Permission> pageInfo = permissionService.findPage(permission);
        List<Permission> list = pageInfo.getList();
        CommonPage page = CommonPage.setPageModel(pageInfo);
        modelMap.put("Permissionlist",list);
        modelMap.put("page",page);

        return "rbac/permission/permission_list";
    }

    @RequestMapping(value = "/permission2Add")
    public String toAddPage(HttpServletRequest request, ModelMap modelMap){
        Permission permission = new Permission();
        modelMap.put("permission",permission);
        String parentIdStr = request.getParameter("parentId");
        if(parentIdStr != null && !parentIdStr.equalsIgnoreCase("")){
            Integer parentId = Integer.parseInt(parentIdStr);
            permission.setParentId(parentId);
        }
        return "rbac/permission/permission_edit";
    }

    @RequestMapping(value = "doCheckCode",method = RequestMethod.POST)
    @ResponseBody
    public Object doCheckCode(HttpServletRequest request){
        Permission permission = new Permission();
        String code = request.getParameter("code");
        permission.setCode(code);
        if(!request.getParameter("id").equalsIgnoreCase("")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            permission.setId(id);
        }
        Integer model = Integer.parseInt(request.getParameter("model"));
        return permissionService.doCheckCode(permission,model);

    }

    @RequestMapping(value = "doSavePermission",method = RequestMethod.POST)
    @ResponseBody
    public Object doSavePermission(@RequestBody Permission permission){
        if(permission == null)
            return null;
        //添加
        permissionService.savePermission(permission);
        CodeMsg codeMsg = new CodeMsg("200","添加成功");
        return codeMsg;

    }

    @RequestMapping(value = "/doLoadPermission")
    public String doLoadPermission(HttpServletRequest request, ModelMap modelMap){
        if(!request.getParameter("id").equalsIgnoreCase("")) {
            Permission permission =
                    permissionService.loadPermission(Integer.parseInt(request.getParameter("id")));
            modelMap.put("permission", permission);
            return "rbac/permission/permission_edit";
        }
        return null;
    }



    @RequestMapping(value = "doUploadPermission",method = RequestMethod.POST)
    @ResponseBody
    public Object doUploadPermission(@RequestBody Permission permission) throws Exception{
        if(permission == null)
            return null;
        permissionService.updateBySelective(permission);
        CodeMsg codeMsg = new CodeMsg("200","修改成功");
        return codeMsg;
    }


    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "doTest14",method = RequestMethod.POST)
    @ResponseBody
    public CodeMsg doUploadPermission14(@RequestBody Permission permission){
        if(permission == null)
            return null;
        Object o = redisUtil.get("a");

        System.out.println("a-value:"+(redisUtil.get("a")).toString());
        redisUtil.set("hello",1234);
        System.out.println("a-value:"+redisUtil.get("hello"));
        System.out.println("========doTest14,name:"+permission.getName());
        CodeMsg codeMsg = new CodeMsg("200014","修改成功");
        return codeMsg;
    }






    @RequestMapping(value = "/findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询权限分页列表")
    @ResponseBody
    public ResponseBean<PageInfo<Permission>> findPage(@RequestBody RequestBean<Permission> requestBean){
        Permission permission = requestBean.getData();
        return ResponseBean.success(permissionService.findPage(permission));
    }

    @RequestMapping(value = "/findPage11",method = RequestMethod.POST)
    @ApiOperation(value = "findPage11")
    @ResponseBody
    public ResponseBean<List<PermissionListDTO>> findPage11(@RequestBody RequestBean<Permission> requestBean){
        //Permission permission = requestBean.getData();
        List<PermissionListDTO> listDTOList = new ArrayList<>();
        permissionService.setPermissionList(listDTOList,0);
        return ResponseBean.success(listDTOList);
    }


    @RequestMapping(value = "/toSavePage",method = RequestMethod.GET)
    @ApiOperation(value = "跳转添加权限页面")
    public String  toSavePage(){
        return "rbac/permission/permission_edit";
    }


    @RequestMapping(value = "/savePermission",method = RequestMethod.POST)
    @ApiOperation(value = "添加权限")
    @ResponseBody
    public ResponseBean<Integer> savePermission(@RequestBody RequestBean<Permission> requestBean){
        Permission permission = requestBean.getData();
        return ResponseBean.success(permissionService.savePermission(permission));
    }


    @RequestMapping(value = "/loadPermission",method = RequestMethod.POST)
    @ApiOperation(value = "添加权限")
    @ResponseBody
    public ResponseBean<Permission> loadPermission(@RequestBody RequestBean<Integer> requestBean){
        return ResponseBean.success(permissionService.loadPermission(requestBean.getData()));
    }

    @RequestMapping(value = "/updatePermission",method = RequestMethod.POST)
    @ApiOperation(value = "修改权限")
    @ResponseBody
    public ResponseBean<Integer> updatePermission(@RequestBody RequestBean<Permission> requestBean){
        Permission permission = requestBean.getData();
        return ResponseBean.success(permissionService.updateBySelective(permission));
    }


}
