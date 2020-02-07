package com.user.base.service;

import com.github.pagehelper.PageInfo;
import com.user.base.entity.model.Permission;

/**
 * @Authod:zeng
 * @Date: 2020/1/7 10:05
 * @Version: 0.0.1
 */
public interface PermissionService {

    PageInfo<Permission> findPage(Permission permission);


    Integer savePermission(Permission permission);


    Permission loadPermission(Integer id);


    Integer updateBySelective(Permission permission);


    Integer countByCode(Permission recode);
}
