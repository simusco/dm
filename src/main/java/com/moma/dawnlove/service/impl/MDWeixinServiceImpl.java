package com.moma.dawnlove.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.moma.dawnlove.http.XmlRequest;
import com.moma.dawnlove.service.MDWeixinService;

@Service
public class MDWeixinServiceImpl implements MDWeixinService{

	private XmlRequest xmlRequest;
	
	@Override
	public void sendTxtMsg(String toUser, String content, String token) {
		
			Long createTime = new Date().getTime();
		
			Map<String, String> text = new HashMap<String, String>();
			text.put("content", content);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("touser", toUser);
			map.put("msgtype", "text");
			map.put("text", text);
			
			String json = JSON.toJSONString(map);
			
			xmlRequest.doPost("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+token, json);
	}

	
	
}
