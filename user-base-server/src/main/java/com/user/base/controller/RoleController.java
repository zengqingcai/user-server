package com.user.base.controller;

import com.github.pagehelper.PageInfo;
import com.user.base.common.CommonPage;
import com.user.base.common.RequestBean;
import com.user.base.common.ResponseBean;
import com.user.base.entity.model.Role;
import com.user.base.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/roleList")
    public String findList(Role role, ModelMap modelMap){
        PageInfo<Role> pageInfo = roleService.findPage(role);
        List<Role> list = roleService.findPage(role).getList();
        CommonPage page = CommonPage.setPageModel(pageInfo);
        modelMap.put("roleList",list);
        modelMap.put("page",page);
        return "rbac/role/role_list";
    }

    @RequestMapping(value = "/toAddPage")
    public String toAddPage(ModelMap modelMap, HttpServletRequest request){
        if(request.getParameter("id")!=null && !request.getParameter("id").equals("")){
            modelMap.put("role",roleService.queryByPrimaryKey(Integer.valueOf(request.getParameter("id"))));
        }else {
            modelMap.put("role",new Role());
        }
        return "rbac/role/role_edit";
    }

    @RequestMapping(value = "doSaveRole",method = RequestMethod.POST)
    @ResponseBody
    public Object doSaveRole(@RequestBody Role role){
        if(role == null)
            return null;
        //添加
        return roleService.saveRole(role);

    }

    @RequestMapping(value = "doUploadRole",method = RequestMethod.POST)
    @ResponseBody
    public Object doUploadRole(@RequestBody Role role){
        if(role == null)
            return null;
        //添加
        return roleService.updateRole(role);

    }

    @RequestMapping(value = "/findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询角色分页列表")
    @ResponseBody
    public ResponseBean<PageInfo<Role>> findPage(@RequestBody @Validated RequestBean<Role> requestBean){
        return ResponseBean.success(roleService.findPage(requestBean.getData()));
    }

    @RequestMapping(value = "/saveRole",method = RequestMethod.POST)
    @ApiOperation(value = "添加角色")
    @ResponseBody
    public ResponseBean<Integer> saveRole(@Validated @RequestBody RequestBean<Role> requestBean){
        return ResponseBean.success(roleService.insertSelective(requestBean.getData()));
    }


    @RequestMapping(value = "/updateRole",method = RequestMethod.POST)
    @ApiOperation(value = "修改角色")
    @ResponseBody
    public ResponseBean<Integer> updateRole(@Validated @RequestBody RequestBean<Role> requestBean){
        return ResponseBean.success(roleService.updateSelective(requestBean.getData()));
    }


    //给角色添加权限
    @RequestMapping(value = "/updateRolePermission",method = RequestMethod.POST)
    @ApiOperation(value = "修改角色-添加权限")
    @ResponseBody
    public ResponseBean<Integer> updateRolePermission(@Validated @RequestBody RequestBean<Map<String,Object>> requestBean){
        return ResponseBean.success(roleService.editPermission(requestBean.getData()));
    }





}
