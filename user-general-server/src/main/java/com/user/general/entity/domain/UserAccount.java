package com.user.general.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户账号信息表
 * </p>
 *
 * @author zeng
 * @since 2020-03-23
 */
@TableName("t_bu_user_account")
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
    private LocalDateTime ct;
    private LocalDateTime ut;
    private Long cid;
    private Long uid;
    private Integer ava;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public LocalDateTime getCt() {
        return ct;
    }

    public void setCt(LocalDateTime ct) {
        this.ct = ct;
    }

    public LocalDateTime getUt() {
        return ut;
    }

    public void setUt(LocalDateTime ut) {
        this.ut = ut;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getAva() {
        return ava;
    }

    public void setAva(Integer ava) {
        this.ava = ava;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
        ", id=" + id +
        ", userId=" + userId +
        ", bank=" + bank +
        ", bankNo=" + bankNo +
        ", account=" + account +
        ", ct=" + ct +
        ", ut=" + ut +
        ", cid=" + cid +
        ", uid=" + uid +
        ", ava=" + ava +
        "}";
    }
}
