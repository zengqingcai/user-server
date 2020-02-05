package com.user.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.base.dao.PermissionMapper;
import com.user.base.entity.model.Permission;
import com.user.base.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/1/7 10:19
 * @Version: 0.0.1
 */
@Service
public class PermissionServiceImpl implements PermissionService {


    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public PageInfo<Permission> findPage(Permission permission) {

        PageHelper.startPage(permission.getCurrentPage(),permission.getPageSize());
        List<Permission> list = permissionMapper.queryByParams(permission);
        PageInfo<Permission> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Integer savePermission(Permission permission) {
        return permissionMapper.insertSelective(permission);
    }

    @Override
    public Permission loadPermission(Integer id) {
        return permissionMapper.selectByPrimary(id);
    }

    @Override
    public Integer updateBySelective(Permission permission) {
        return permissionMapper.updateBySelective(permission);
    }
}
