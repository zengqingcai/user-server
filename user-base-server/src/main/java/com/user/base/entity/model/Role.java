package com.user.base.entity.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Role {


    private Integer id;

    @NotNull(message = "角色名称不能为空")
    private String name;

    private String available;

}