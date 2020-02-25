package com.user.base.service;

import com.github.pagehelper.PageInfo;
import com.user.base.comm.CodeMsg;
import com.user.base.entity.dto.permission.PermissionListDTO;
import com.user.base.entity.model.Permission;

import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/1/7 10:05
 * @Version: 0.0.1
 */
public interface PermissionService {

    PageInfo<Permission> findPage(Permission permission);


    CodeMsg doCheckCode(Permission permission,Integer model);


    Integer savePermission(Permission permission);


    Permission loadPermission(Integer id);


    Integer updateBySelective(Permission permission);


    Integer countByCode(Permission recode);


    void setPermissionList(List<PermissionListDTO> list,Integer parentId);
}
