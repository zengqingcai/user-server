package com.user.account.comm;

import lombok.Data;

@Data
public class RequestBean<T> {

    private Integer code;

    private String message;

    private T item;


    

}
