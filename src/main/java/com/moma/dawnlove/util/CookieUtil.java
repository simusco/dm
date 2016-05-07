package com.moma.dawnlove.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CookieUtil(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
    /**
     * Cookie 追加
     * @return
     * @throws Exception
     */
    public void addCookie(String name,String value, int timeLong){
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(timeLong);
        response.addCookie(cookie);
    }
    /**
     * Cookie 取得
     * @return
     * @throws Exception
     */
    public String getCookie(String name){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies)
            {
                if(cookie.getName().equals(name))
                {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}