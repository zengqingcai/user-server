package com.user.base.common;


import lombok.Data;

@Data
public class ResponseBean<T> {

    private String code;

    private String message;

    private T data;

    /**
     *  成功时候的调用
     *  不带code message
     * */
    public static  <T> ResponseBean<T> success(T data){
        return new ResponseBean<T>(data);
    }


    /**
     * 带message code的返回
     * @param codeMsg
     * @param data
     * @param <T>
     * @return
     */
    public static  <T> ResponseBean<T> success(CodeMsg codeMsg,T data){
        return new ResponseBean<T>(codeMsg.getCode(),codeMsg.getMessage(),data);
    }

    /**
     *  失败时候的调用
     * */
    public static  <T> ResponseBean<T> error(CodeMsg codeMsg,T data){
        return new ResponseBean<T>(codeMsg,data);
    }




    private ResponseBean(T data) {
        this("0000","成功",data);
    }

    private ResponseBean(String code, String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ResponseBean(CodeMsg codeMsg) {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.message = codeMsg.getMessage();
        }
    }

    private ResponseBean(CodeMsg codeMsg,T data) {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.message = codeMsg.getMessage();
        }
        this.data = data;
    }





}
