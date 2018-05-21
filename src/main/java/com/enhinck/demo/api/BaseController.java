package com.enhinck.demo.api;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component("baseController")
public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private RedisTemplate<String, Long> redisTemplate;

	@Resource
	protected HttpServletRequest request;

	@Resource
	protected HttpServletResponse response;

	/**
	 * 获取session对象
	 */
	protected HttpSession getSession() {
		return request.getSession();
	}

	/**
	 * 获取request对象
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
}
