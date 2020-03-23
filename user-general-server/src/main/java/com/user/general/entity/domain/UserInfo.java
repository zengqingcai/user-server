package com.user.general.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zeng
 * @since 2020-03-23
 */
@TableName("t_bu_user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 基本用户表id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;
    private Integer age;
    /**
     * 0:男 1:女
     */
    private Integer sex;
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;
    private LocalDateTime ct;
    private LocalDateTime ut;
    private Long cid;
    private Long uid;
    /**
     * 0:无效 1:有效
     */
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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
        return "UserInfo{" +
        ", id=" + id +
        ", userId=" + userId +
        ", userName=" + userName +
        ", age=" + age +
        ", sex=" + sex +
        ", lastLoginTime=" + lastLoginTime +
        ", ct=" + ct +
        ", ut=" + ut +
        ", cid=" + cid +
        ", uid=" + uid +
        ", ava=" + ava +
        "}";
    }
}
