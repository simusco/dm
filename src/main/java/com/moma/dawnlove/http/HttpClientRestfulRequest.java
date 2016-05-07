package com.moma.dawnlove.http;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.moma.dawnlove.ErrorCode;
import com.moma.dawnlove.exception.WebException;

@Component
public class HttpClientRestfulRequest implements RestfulRequest {

	private CloseableHttpClient httpClient = null;

	@PostConstruct
	public void init() {
		HttpClientBuilder builder = HttpClientBuilder.create();
		httpClient = builder.build();
	}

	protected void setHeaders(HttpRequestBase reqeust, Map<String, String> headers) {
		if (headers != null) {
			for (Iterator<String> it = headers.keySet().iterator(); it.hasNext();) {
				String key = it.next();
				String value = headers.get(key);
				reqeust.addHeader(key, value);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> doGet(String url, Map<String, String> params, Map<String, String> headers) {

		try {
			// 设置参数
			if (params != null && !params.isEmpty()) {
				List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
				for (Map.Entry<String, String> entry : params.entrySet()) {
					String value = entry.getValue();
					if (value != null) {
						pairs.add(new BasicNameValuePair(entry.getKey(), value));
					}
				}
				url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, "UTF-8"));
			}

			HttpGet httpGet = new HttpGet(url);
			// 设置请求头
			this.setHeaders(httpGet, headers);

			CloseableHttpResponse response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpGet.abort();
				throw new WebException(ErrorCode.HTTP_REQUEST_ERROR.code,
						"HttpClient,error status code :" + statusCode);
			}

			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);

			response.close();
			return (Map<String, Object>) JSON.parse(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * HTTP Get 获取内容
	 * 
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 */
	public Map<String, Object> doGet(String url, Map<String, String> params) {
		return this.doGet(url, params, null);
	}

	/**
	 * HTTP Post 获取内容
	 * 
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> doPost(String url, Map<String, Object> params, Map<String, String> headers) {
		try {
			HttpPost httpPost = new HttpPost(url);
			this.setHeaders(httpPost, headers);
			
			if(headers != null && params != null && "application/json".equalsIgnoreCase(headers.get(HTTP.CONTENT_TYPE))){
				httpPost.setEntity(new StringEntity(JSON.toJSONString(params), "utf-8"));
			}else{
				List<NameValuePair> pairs = null;
				if (params != null && !params.isEmpty()) {
					pairs = new ArrayList<NameValuePair>(params.size());
					for (Map.Entry<String, Object> entry : params.entrySet()) {
						Object value = entry.getValue();
						if (value != null) {
							pairs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(value)));
						}
					}
				}
				
				if(pairs != null)
					httpPost.setEntity(new UrlEncodedFormEntity(pairs, "utf-8"));
			}
			
			System.out.println(httpPost.toString());

			CloseableHttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPost.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}

			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
			response.close();

			return (Map<String, Object>) JSON.parse(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Map<String, Object> doPost(String url, Map<String, Object> params) {
		return this.doPost(url, params, null);
	}

	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> doDelete(String url, Map<String, String> headers) {

		try {
			HttpDelete httpDelete = new HttpDelete(url);
			// 设置请求头
			this.setHeaders(httpDelete, headers);

			CloseableHttpResponse response = httpClient.execute(httpDelete);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpDelete.abort();
				throw new WebException(ErrorCode.HTTP_REQUEST_ERROR.code,
						"HttpClient,error status code :" + statusCode);
			}

			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);

			response.close();
			return (Map<String, Object>) JSON.parse(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * HTTP Get 获取内容
	 * 
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 */
	public Map<String, Object> doDelete(String url) {
		return this.doDelete(url, null);
	}
	
	
	/**
	 * HTTP Delete 获取内容
	 * 
	 * @param url
	 *            请求的url地址 ?之前的地址
	 * @param params
	 *            请求的参数
	 * @param charset
	 *            编码格式
	 * @return 页面内容
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> doPut(String url, Map<String, Object> params, Map<String, String> headers) {
		try {
			HttpPut httpPut = new HttpPut(url);
			this.setHeaders(httpPut, headers);
			
			if(headers != null && params != null && "application/json".equalsIgnoreCase(headers.get(HTTP.CONTENT_TYPE))){
				httpPut.setEntity(new StringEntity(JSON.toJSONString(params), "utf-8"));
			}else{
				List<NameValuePair> pairs = null;
				if (params != null && !params.isEmpty()) {
					pairs = new ArrayList<NameValuePair>(params.size());
					for (Map.Entry<String, Object> entry : params.entrySet()) {
						Object value = entry.getValue();
						if (value != null) {
							pairs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(value)));
						}
					}
				}
				
				if(pairs != null)
					httpPut.setEntity(new UrlEncodedFormEntity(pairs, "utf-8"));
			}

			CloseableHttpResponse response = httpClient.execute(httpPut);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				httpPut.abort();
				throw new RuntimeException("HttpClient,error status code :" + statusCode);
			}

			HttpEntity entity = response.getEntity();
			String result = null;
			if (entity != null) {
				result = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);
			response.close();

			return (Map<String, Object>) JSON.parse(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Map<String, Object> doPut(String url, Map<String, Object> params) {
		return this.doPut(url, params, null);
	}
}
