package com.user.base.remote.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.user.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "用户账户实体")
public class UserAccount extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String account;

    private String bankNo;

    private BigDecimal bankMoney;

    private String alipayAccount;

    private BigDecimal alipayMoney;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    private LocalDateTime updatedTime;

    private Boolean enable;


}