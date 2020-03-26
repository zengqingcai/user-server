package com.user.common.model;

/**
 * @Authod:zeng
 * @Date: 2020/3/25 9:08
 * @Version: 0.0.1
 */

public enum CodeMsgEnum {

    KEY_EXCEPTION("0001", "账号重复"),

    OTHER_FAST("0002", "快速失败");

    private String code;

    private String message;



    CodeMsgEnum(String code, String message) {
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
}
