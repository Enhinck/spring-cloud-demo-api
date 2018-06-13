package com.enhinck.demo.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;

/**
 * 扩展的AuthenticationToken
 */
public class ShiroExtToken implements AuthenticationToken, RememberMeAuthenticationToken {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4350909676950551683L;
	private boolean rememberMe = false;
	// 是否已登录并已缓存情况
	private boolean isCache = false;


    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

	public boolean isCache() {
		return isCache;
	}

	public void setCache(boolean isCache) {
		this.isCache = isCache;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

}
