package com.moma.dawnlove.exception;

public class ServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2006318027625586321L;
	private String code;
	
	public ServiceException(String msg) {
		super(msg);
	}
	
	public ServiceException(String code, String msg) {
		super(msg);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
}
