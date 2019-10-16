package com.user.base.dao;

import com.user.base.entity.model.RolePermission;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {

    List<RolePermission> queryByParams(RolePermission rolePermission);

    Integer deleteByExample(RolePermission rolePermission);

    Integer insertSelective(RolePermission rolePermission);
}