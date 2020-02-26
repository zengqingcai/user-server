package com.user.base.service;

import com.github.pagehelper.PageInfo;
import com.user.base.comm.CodeMsg;
import com.user.base.entity.model.Role;

import java.util.Map;

public interface RoleService {

    PageInfo<Role> findPage(Role role);

    Role queryByPrimaryKey(Integer id);

    Integer insert(Role role);

    Integer insertSelective(Role role);

    CodeMsg saveRole(Role role);

    Integer updateSelective(Role role);


    Integer editPermission(Map<String,Object> params);
}
