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
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

    private Integer currentPage = 1;

    private Integer pageSize = 10;



}
