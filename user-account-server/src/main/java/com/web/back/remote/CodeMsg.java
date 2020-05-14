package com.web.back.remote;

public class CodeMsg {
	
	private String code;
	private String message;
	
	//通用的错误码
	public static CodeMsg SUCCESS = new CodeMsg("0000", "成功");
	
	
	private CodeMsg() {
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
