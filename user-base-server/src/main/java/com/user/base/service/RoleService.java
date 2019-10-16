package com.user.base.service;

import com.user.base.entity.model.Role;

public interface RoleService {

    Role queryByPrimaryKey(Integer id);

    Integer insert(Role role);

    Integer insertSelective(Role role);

    Integer updateSelective(Role role);
}
