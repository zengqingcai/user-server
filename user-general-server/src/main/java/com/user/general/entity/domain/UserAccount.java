package com.user.general.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户账号信息表
 * </p>
 *
 * @author zeng
 * @since 2020-03-23
 */
@TableName("t_bu_user_account")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * t_bu_base_user表id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 开户行
     */
    private String bank;
    /**
     * 银行卡号
     */
    @TableField("bank_no")
    private String bankNo;
    /**
     * 账号
     */
    private String account;
    private Date ct;
    private Date ut;
    private Long cid;
    private Long uid;
    private Integer ava;

    private Integer currentPage = 1;

    private Integer pageSize = 10;

}
