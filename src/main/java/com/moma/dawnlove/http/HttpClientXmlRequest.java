package com.moma.dawnlove.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class HttpClientXmlRequest {

	public String doPost(String strUrl, String content) {
		
		HttpURLConnection httpCon = null;
		try {
			URL url = new URL(strUrl);
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setRequestMethod("POST");
			httpCon.setDoOutput(true);
			httpCon.setDoInput(true);
			httpCon.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			httpCon.setRequestProperty("Content-Length", String.valueOf(content.length()));

			OutputStream outputStream = httpCon.getOutputStream();
			outputStream.write(content.getBytes("UTF-8"));
			outputStream.close();

			InputStream inputStream = httpCon.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			
			StringBuffer result = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			
			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (httpCon != null) {
				httpCon.disconnect();
			}
		}
		
		return null;
	}
	
}
