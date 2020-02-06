package com.user.common.exception;

import java.util.HashMap;
import java.util.Map;

public enum BuExceptionEnum {


    ID_MUST("10002", "请输入id！"),

    ACCOUNT_AGAINT("10001", "账号重复！"),

    ILLEGAL_PARAMETERS("99999","不合法的请求参数");

    /** 异常代码 */
    private String code;

    /** 异常消息 */
    private String message;

    BuExceptionEnum(String code, String message) {
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
        for (BuExceptionEnum buExceptionEnum : values()) {
            map.put(buExceptionEnum.getCode(), buExceptionEnum.getMessage());
        }
        return map;
    }
}
