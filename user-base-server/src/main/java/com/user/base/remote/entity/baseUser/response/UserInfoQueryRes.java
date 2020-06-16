package com.user.base.remote.entity.baseUser.response;

import lombok.Data;

/**
 * @Authod:zeng
 * @Date: 2020/6/16 9:11
 * @Version: 0.0.1
 */
@Data
public class UserInfoQueryRes {

    private Long id;

    private String code;

    private String userName;

    private String address;

    private String age;

    private String sex;


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = "女";
        if(sex.equals("0")){
            this.sex = "男";
        }
    }
}
