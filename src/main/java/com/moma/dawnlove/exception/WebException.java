package com.moma.dawnlove.exception;

import com.moma.dawnlove.web.WebResult;

public class WebException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1412531234961387773L;
	private String code;
	private String msg;
	private Object object;
	
	public WebException(String msg){
		this.msg = msg;
	}
	
	public WebException(String code, String msg) {
		super(msg);
		
		this.code = code;
		this.msg = msg;
	}
	
	public WebException(Object object, String code, String msg) {
		super(msg);
		
		this.code = code;
		this.msg = msg;
		this.object = object;
	}
	
	public WebResult toWebResult(){
		return new WebResult(object, code, msg);
	}

}
