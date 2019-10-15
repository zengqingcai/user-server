package com.user.base.entity.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Permission {


    private Integer id;

    @NotNull(message = "资源名称不能为空")
    private String name;

    private String type;

    private String url;

    private String percode;

    private Integer parentid;

    private String parentids;

    private String sortstring;

    private String available;

}