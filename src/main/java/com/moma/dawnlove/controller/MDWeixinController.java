package com.moma.dawnlove.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moma.dawnlove.util.CryptUtil;
import com.moma.dawnlove.web.springmvc.RestfulController;

@Scope(value = "prototype")
@RequestMapping("/weixin")
@Controller("MDWeixinController")
public class MDWeixinController  extends RestfulController {

	private String token = "maopaihuomd";
	
	@RequestMapping(value="/token",method = RequestMethod.GET)
	public String token(String signature, String timestamp, String nonce, String echostr) throws Exception {
		
		String[] paramStrings = new String[]{token, timestamp, nonce};
		List<String> ll = Arrays.asList(paramStrings);
		Collections.sort(ll);
		
		String str = "";
		for(int i=0;i<ll.size();i++){
			str += ll.get(i);
		}
		
		String sign = CryptUtil.SHA1(str);
		if(sign.equals(signature)){
			return echostr;
		}
		
		return "";
	}
	
	
	
}
