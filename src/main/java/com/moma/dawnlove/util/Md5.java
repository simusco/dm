package com.moma.dawnlove.util;

import org.apache.commons.codec.digest.Md5Crypt;

public class Md5 {

	public static String encode(String password, String salt) {
		return Md5Crypt.apr1Crypt(password, salt);
	}

}
