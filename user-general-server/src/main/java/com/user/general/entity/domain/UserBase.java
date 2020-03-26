package com.user.general.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 用户基础表
 * </p>
 *
 * @author zeng
 * @since 2020-03-23
 */
@TableName("t_bu_user_base")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 登陆账号
     */
    private String code;
    /**
     * 登陆密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    private Date ct;
    private Date ut;
    private Long cid;
    private Long uid;
    private Integer ava;

    private Integer currentPage  = 1;

    private Integer pageSize = 10;


}