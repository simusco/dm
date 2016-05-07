package com.moma.dawnlove.util;

import java.util.Date;
import java.util.UUID;

public class UUIDUtils {

	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String getRandomID(){
		String d = String.valueOf(new Date().getTime() / 1000);
		String r = RandomUtils.getRandom(8);
		return d + r;
	}
	
	public static void main(String[] args){
		long c = System.currentTimeMillis();
		
		for(int i=0;i<10000000;i++){
			getRandomID();
		}
		
		System.out.println(System.currentTimeMillis() - c);
	}
	
}
