package com.user.base.dao;

import com.user.base.entity.model.UserRole;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {

    List<UserRole> queryByParams(UserRole userRole);

    Integer deleteByParams(UserRole userRole);

    Integer insertSelective(UserRole userRole);
}