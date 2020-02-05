package com.user.base.dao;

import com.user.base.entity.model.RolePermission;

import java.util.List;

public interface RolePermissionMapper {

    List<RolePermission> queryByParams(RolePermission rolePermission);

    Integer deleteByExample(RolePermission rolePermission);

    Integer insertSelective(RolePermission rolePermission);
}