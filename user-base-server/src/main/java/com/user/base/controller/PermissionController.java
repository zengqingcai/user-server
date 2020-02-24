package com.user.base.controller;

import com.github.pagehelper.PageInfo;
import com.user.base.comm.CodeMsg;
import com.user.base.comm.CommonPage;
import com.user.base.comm.RequestBean;
import com.user.base.comm.ResponseBean;
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
        String model = request.getParameter("model");
        if(model.equalsIgnoreCase("0")){
            return "rbac/permission/permission_edit";
        }

        return "rbac/permission/permission_edit";
    }

    @RequestMapping(value = "doSavePermission",method = RequestMethod.POST)
    @ResponseBody
    public Object doSavePermission(@RequestBody Permission permission,HttpServletRequest request)throws Exception{
        if(permission == null)
            return null;
        //添加
        if(request.getParameter("model").equalsIgnoreCase("0")){
            CodeMsg codeMsg = new CodeMsg("200","");
            return codeMsg;
        }
        return null;
    }




    @RequestMapping(value = "/findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询权限分页列表")
    @ResponseBody
    public ResponseBean<PageInfo<Permission>> findPage(@RequestBody RequestBean<Permission> requestBean){
        Permission permission = requestBean.getData();
        return ResponseBean.success(permissionService.findPage(permission));
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
