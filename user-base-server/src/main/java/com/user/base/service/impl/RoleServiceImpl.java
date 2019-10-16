package com.user.base.service.impl;

import com.user.base.dao.RoleMapper;
import com.user.base.entity.model.Role;
import com.user.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


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
        return roleMapper.insertSelective(role);
    }

    @Override
    public Integer updateSelective(Role role) {
        return roleMapper.updateSelective(role);
    }
}
