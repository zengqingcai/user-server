package com.user.base.dao;

import com.user.base.entity.model.Permission;
import com.user.base.entity.model.Role;
import com.user.base.entity.model.UserRole;

import java.util.List;

public interface UserRoleMapper {

    List<UserRole> queryByParams(UserRole userRole);

    Integer deleteByParams(UserRole userRole);

    Integer insertSelective(UserRole userRole);

    List<Role> queryRolesByUserId(Integer sysUserId);

    List<Permission> queryPersByRoleId(Integer sysRoleId);

    Integer insertUserRoles(List<UserRole> list);
}