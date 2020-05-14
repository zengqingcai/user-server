package com.web.back.entity.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.user.account.entity.BaseEntity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zengyiliang
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
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
