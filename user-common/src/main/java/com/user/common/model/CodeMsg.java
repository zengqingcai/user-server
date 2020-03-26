package com.user.common.model;

public class CodeMsg {
	
	private String code;
	private String message;
	
	//通用的错误码
	public static CodeMsg SUCCESS = new CodeMsg("0000", "成功");
	public static CodeMsg ERROR = new CodeMsg("-1", "系统异常");
	public static CodeMsg PARAM_ERROR = new CodeMsg("-1", "系统异常");
	
	
	private CodeMsg() {
	}

	public CodeMsg(CodeMsgEnum codeMsgEnum) {
		this.code = codeMsgEnum.getCode();
		this.message = codeMsgEnum.getMessage();
	}
			
	public CodeMsg(String code, String message ) {
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
	
	public CodeMsg fillArgs(Object... args) {
		String code = this.code;
		String message = String.format(this.message, args);
		return new CodeMsg(code, message);
	}

	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", msg=" + message + "]";
	}
	
	
}
