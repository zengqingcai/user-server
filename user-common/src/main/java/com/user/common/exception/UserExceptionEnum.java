package com.user.common.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/3/26 11:27
 * @Version: 0.0.1
 */
public enum UserExceptionEnum {

    ACCOUNT_AGAINT("10001", "账号重复！"),

    ID_MUST("10002", "请输入id！");

    /** 异常代码 */
    private String code;

    /** 异常消息 */
    private String message;

    UserExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Map<String, String> convertToMap() {
        Map<String, String> map = new HashMap<>();
        for (UserExceptionEnum userExceptionEnum : values()) {
            map.put(userExceptionEnum.getCode(), userExceptionEnum.getMessage());
        }
        return map;
    }
}
