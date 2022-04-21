package com.airlisite.exception;

@SuppressWarnings("serial")
public class ExceptionBase extends Exception{
	private String code;
	private String msg;
	private String other;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg(){
		return this.msg;
	}
	public void setMsg(String msg){
		this.msg = msg;
	}
	
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public ExceptionBase(String code,String msg,String exception){
		super(exception);
		this.code = code;
		this.msg = msg;
	}
	public ExceptionBase(String code,String msg,String other,String exception){
		super(exception);
		this.code = code;
		this.msg = msg;
		this.other = other;
	}
	public ExceptionBase(String code,String msg,String other,Throwable e){
		super(e);
		this.code = code;
		this.msg = msg;
		this.other = other;		
	}
	public ExceptionBase(String code,String msg,Throwable e){
		super(e);
		this.code = code;
		this.msg = msg;
	}	
}
