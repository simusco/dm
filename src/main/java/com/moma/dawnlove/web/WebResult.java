package com.moma.dawnlove.web;

import java.io.Serializable;

public class WebResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5261001908221223139L;

	private String code;
	private String msg;
	private Object result;
	
	public WebResult(Object result, String code, String msg){
		this.result = result;
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
