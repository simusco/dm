package com.moma.dawnlove.http;

import java.util.Map;

public interface RestfulRequest {
	
	public Map<String, Object> doGet(String url, Map<String, String> params, Map<String, String> headers);

	public Map<String, Object> doGet(String url, Map<String, String> params);
	
	public Map<String, Object> doPost(String url, Map<String, Object> params);
	
	public Map<String, Object> doPost(String url, Map<String, Object> params, Map<String, String> headers);
	
	public Map<String, Object> doPut(String url, Map<String, Object> params);
	
	public Map<String, Object> doPut(String url, Map<String, Object> params, Map<String, String> headers);
	
	public Map<String, Object> doDelete(String url);
	
	public Map<String, Object> doDelete(String url, Map<String, String> headers);
	
}
