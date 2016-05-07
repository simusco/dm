package com.moma.dawnlove.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

public class HttpRequestUtils {

	public static String doPostRequest(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		ResponseHandler<byte[]> handler = new ResponseHandler<byte[]>() {
		    public byte[] handleResponse(
		        HttpResponse response) throws ClientProtocolException, IOException {
		        HttpEntity entity = response.getEntity();
		        if (entity != null) {
		            return EntityUtils.toByteArray(entity);
		        } else {
		            return null;
		        }
		    }
		};
		
		byte[] bytes = httpclient.execute(post, handler);
		
		return new String(bytes);
	}
	
	public static String doGetRequest(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		
		HttpGet post = new HttpGet(url);

		ResponseHandler<byte[]> handler = new ResponseHandler<byte[]>() {
		    public byte[] handleResponse(
		        HttpResponse response) throws ClientProtocolException, IOException {
		        HttpEntity entity = response.getEntity();
		        if (entity != null) {
		            return EntityUtils.toByteArray(entity);
		        } else {
		            return null;
		        }
		    }
		};
		
		byte[] bytes = httpclient.execute(post, handler);
		
		return new String(bytes);
	}
	
	public static String doGetHttpsRequest(String url) throws ClientProtocolException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException{
		SSLContextBuilder builder = new SSLContextBuilder();
	    builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
	    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
	            builder.build());
	    CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(
	            sslsf).build();
		
		HttpGet post = new HttpGet(url);

		ResponseHandler<byte[]> handler = new ResponseHandler<byte[]>() {
		    public byte[] handleResponse(
		        HttpResponse response) throws ClientProtocolException, IOException {
		        HttpEntity entity = response.getEntity();
		        if (entity != null) {
		            return EntityUtils.toByteArray(entity);
		        } else {
		            return null;
		        }
		    }
		};
		
		byte[] bytes = httpclient.execute(post, handler);
		
		return new String(bytes);
	}
	
	
	
}
