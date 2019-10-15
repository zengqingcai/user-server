package com.user.base.entity.model;


import lombok.Data;

@Data
public class RolePermission {


    private String id;

    private Integer sysRoleId;

    private Integer sysPermissionId;

}