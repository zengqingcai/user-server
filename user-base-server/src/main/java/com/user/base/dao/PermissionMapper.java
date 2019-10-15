package com.user.base.dao;

import com.user.base.entity.model.Permission;

import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper {

    Integer insert(Permission record);

    Integer insertSelective(Permission record);

    Integer updateBySelective(Permission recode);

    Permission selectByPrimary(Integer id);
}