package com.user.base.service;

import com.github.pagehelper.PageInfo;
import com.user.base.common.CodeMsg;
import com.user.base.entity.model.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

    PageInfo<Role> findPage(Role role);

    Role queryByPrimaryKey(Integer id);

    Integer insert(Role role);

    Integer insertSelective(Role role);

    CodeMsg saveRole(Role role);

    CodeMsg updateRole(Role role);

    Integer updateSelective(Role role);


    Integer editPermission(Map<String,Object> params);

    List<Role> queryAllRols();
}
