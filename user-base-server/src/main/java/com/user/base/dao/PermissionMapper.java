package com.user.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.base.entity.model.Permission;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    Integer insertSelective(Permission record);

    Integer updateBySelective(Permission recode);

    Permission selectByPrimary(Integer id);

    List<Permission> queryByParams(Permission params);
}