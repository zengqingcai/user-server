package com.user.base.controller;

import com.github.pagehelper.PageInfo;
import com.user.base.comm.RequestBean;
import com.user.base.comm.ResponseBean;
import com.user.base.entity.model.Permission;
import com.user.base.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping(value = "/findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询权限分页列表")
    @ResponseBody
    public ResponseBean<PageInfo<Permission>> findPage(@RequestBody RequestBean<Permission> requestBean){
        Permission permission = requestBean.getData();
        return ResponseBean.success(permissionService.findPage(permission));
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
