package com.user.base.entity.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Authod:zeng
 * @Date: 2020/3/30 16:32
 * @Version: 0.0.1
 */
@Data
public class MedicineInfoQueryRq {

    private Long medicineBaseId;
    /**
     * 介绍
     */
    private String introduction;
    /**
     * 功效
     */
    private String efficacy;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 单位
     */
    private Integer unit;
    /**
     * 生产时间
     */
    private Date productionTime;
    /**
     * 生成地址
     */
    private Date productionAddr;
    /**
     * 公司
     */
    private String productionCompany;
    /**
     * 规格1：100片/瓶
     */
    private Integer specification;
    /**
     * 形状1：颗粒 2：粉状
     */
    private Integer shape;
    /**
     * 备注
     */
    private String note;


    private Integer currentPage = 1;

    private Integer pageSize = 2;
}
