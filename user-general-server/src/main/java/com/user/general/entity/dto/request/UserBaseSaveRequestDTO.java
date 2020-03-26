package com.user.general.entity.dto.request;

import java.io.Serializable;

/**
 * @Authod:zeng
 * @Date: 2020/3/24 9:37
 * @Version: 0.0.1
 */
public class UserBaseSaveRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 登陆账号
     */
    private String code;
    /**
     * 登陆密码
     */
    private String password;
}
