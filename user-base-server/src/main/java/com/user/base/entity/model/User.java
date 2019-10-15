package com.user.base.entity.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {

    private String id;

    @NotNull(message = "usercode不能为空")
    private String usercode;

    @NotNull(message = "username不能为空")
    private String username;

    @NotNull(message = "password不能为空")
    private String password;

    @NotNull(message = "salt 不能为空")
    private String salt;

    private String locked;
}