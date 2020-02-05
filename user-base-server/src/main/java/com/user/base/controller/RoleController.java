package com.user.base.controller;

import com.github.pagehelper.PageInfo;
import com.user.base.comm.RequestBean;
import com.user.base.comm.ResponseBean;
import com.user.base.entity.model.Role;
import com.user.base.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Authod:zeng
 * @Date: 2020/1/7 16:39
 * @Version: 0.0.1
 */

@Controller
@RequestMapping("/role")
@Api(value = "角色管理", description = "角色管理接口")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询角色分页列表")
    @ResponseBody
    public ResponseBean<PageInfo<Role>> findPage(@RequestBody RequestBean<Role> requestBean){
        return ResponseBean.success(roleService.findPage(requestBean.getData()));
    }

    @RequestMapping(value = "/saveRole",method = RequestMethod.POST)
    @ApiOperation(value = "添加角色")
    @ResponseBody
    public ResponseBean<Integer> saveRole(@Validated @RequestBody RequestBean<Role> requestBean){
        return ResponseBean.success(roleService.insertSelective(requestBean.getData()));
    }

}
