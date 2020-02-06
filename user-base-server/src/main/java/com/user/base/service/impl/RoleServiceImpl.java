package com.user.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.base.dao.RoleMapper;
import com.user.base.dao.RolePermissionMapper;
import com.user.base.entity.model.Role;
import com.user.base.entity.model.RolePermission;
import com.user.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;


    @Override
    public PageInfo<Role> findPage(Role role) {

        PageHelper.startPage(role.getCurrentPage(),role.getPageSize());
        List<Role> list = roleMapper.queryByParams(role);
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Role queryByPrimaryKey(Integer id) {
        return roleMapper.queryByPrimaryKey(id);
    }

    @Override
    public Integer insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public Integer insertSelective(Role role) {
        Integer i =  roleMapper.insertSelective(role);
        System.out.println("id-value:"+role.getId());
        return i;
    }

    @Override
    public Integer updateSelective(Role role) {
        return roleMapper.updateSelective(role);
    }

    @Override
    @Transactional
    public Integer editPermission(Map<String, Object> params) {
        if(params.get("sysRoleId") != null && params.get("sysPermissionIds") !=null){
            if(params.get("sysRoleId") instanceof Integer && params.get("sysPermissionIds") instanceof List){
                Integer sysRoleId = Integer.valueOf(params.get("sysRoleId").toString());
                RolePermission rolePermission = new RolePermission();
                rolePermission.setSysRoleId(sysRoleId);
                //删除旧的数据
                rolePermissionMapper.deleteByExample(rolePermission);
                List<Integer> sysPermissionIds = (List<Integer>)params.get("sysPermissionIds");
                sysPermissionIds.forEach(permissionId->{
                    RolePermission rp = new RolePermission();
                    rp.setSysRoleId(sysRoleId);
                    rp.setSysPermissionId(permissionId);
                    rolePermissionMapper.insertSelective(rp);
                });
                return 1;
            }
        }
        return -1;
    }
}
