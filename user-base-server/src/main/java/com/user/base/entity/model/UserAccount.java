package com.user.base.entity.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserAccount {
    private Integer id;

    private Integer userId;

    private String account;

    private String bankNo;

    private BigDecimal bankMoney;

    private String alipayAccount;

    private BigDecimal alipayMoney;

    private Date createdTime;

    private Date updatedTime;

    private Boolean enable;
}