package com.moma.dawnlove.util;

import java.util.Random;

public class RandomUtils {

	public static String getRandom(int min, int max) {
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		return String.valueOf(s);
	}
	
	public static String getRandom(int len){
        //验证码
        String code = "";
        for (int i = 0; i < len; i++) {
        	code = code + (int)(Math.random() * 9);
        }
        return code;
    }

	public static void main(String[] args) {
		
		String id = RandomUtils.getRandom(20);
		System.out.println(id);
		
	}
	
}
