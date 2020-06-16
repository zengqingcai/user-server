package com.user.base.entity.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Authod:zeng
 * @Date: 2020/3/30 14:34
 * @Version: 0.0.1
 */
@Data
public class MedicalCategoryQueryRq implements Serializable{

    private String categoryCode;

    private String categoryName;

    private String categoryOf;

    private Integer status;

    private Integer currentPage = 1;

    private Integer pageSize = 2;

}

