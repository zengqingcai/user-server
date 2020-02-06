package com.user.base.entity.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@TableName("t_sys_role")
public class Role {


    private Integer id;

    @NotNull(message = "角色名称不能为null")
    @NotEmpty(message = "角色名称不能为空")
    private String name;

    private String available;

    private Integer currentPage = 1;

    private Integer pageSize = 10;


}