package com.airlisite.exception;



public class BookShopException extends ExceptionBase{
	private static final long serialVersionUID = 1L;
	public BookShopException(String code,String msg,String exception){
		super(code,msg,exception);
	}
	public BookShopException(String code,String msg,String other,String exception){
		super(code,msg,other,exception);
	}
	public BookShopException(String code,String msg,String other,Throwable e){
		super(code,msg,other,e);
	}
	public BookShopException(String code,String msg,Throwable e){
		super(code,msg,e);
	}	
}
