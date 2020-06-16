package com.user.base.entity.dto.request;

import lombok.Data;

/**
 * @Authod:zeng
 * @Date: 2020/3/30 16:16
 * @Version: 0.0.1
 */
@Data
public class MedicineBaseQueryRq {


    private Integer medicalCategoryId;
    /**
     * 药品名称
     */
    private String medicineName;
    /**
     * 药品编码
     */
    private String medicineCode;
    /**
     * 1：启用 0：禁用
     */
    private Integer status;


    private Integer currentPage = 1;


    private Integer pageSize = 10;
}
