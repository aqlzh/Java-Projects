/**
 * 
 */
package com.airlisite.exception;

/**
 * @author Administrator
 *
 */
public enum BookShopExceptionTypeEnum implements ExceptionType{
	
	COMMON_SYSTEM_ERROR_CODE("999999","系统错误");
	
	
	
	
	private String code;
	private String msg;
	
	private BookShopExceptionTypeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	
}
