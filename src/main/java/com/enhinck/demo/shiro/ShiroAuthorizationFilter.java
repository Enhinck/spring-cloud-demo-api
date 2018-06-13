package com.enhinck.demo.shiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: Enhinck
 * @description: 对没有登录的请求进行拦截, 全部返回json信息. 覆盖掉shiro原本的跳转login.jsp的拦截方式
 * @date: 2018/04/03 16:00
 */
@Component("shiroAuthorizationFilter")
public class ShiroAuthorizationFilter extends FormAuthenticationFilter {

	// 登录成功后响应头添加
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		// Long userId = (Long)
		// SecurityUtils.getSubject().getSession().getAttribute(GlobalConstants.SESSION_KEY_USER);
		// UserVO userVO = userInfoCache.get(userId.toString());

		// String cacheToken = cacheTokenVO(userVO);
		//HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		// CustomHttpHeaderUtil.setLongToken(httpServletResponse, cacheToken);
		// CustomHttpHeaderUtil.setUserId(httpServletResponse,
		// userVO.getId().toString());

		return super.onLoginSuccess(token, subject, request, response);
	}

	/**
	 * 校验当前请求是否已登录（token）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean authentication(HttpServletRequest request, HttpServletResponse response) {

		if (request.getMethod().equalsIgnoreCase("POST")
				&& request.getRequestURI().startsWith("/api/authentication/login")) {
			return false;
		}

		if (request.getRequestURI().startsWith("/openapi/")) {
			return true;
		}

		if (CorsUtils.isPreFlightRequest(request)) {
			return true;
		}

		// String userId = CustomHttpHeaderUtil.getUserId(request);
		// String systemId = CustomHttpHeaderUtil.getSystemId(request);
		// request.getSession().setAttribute(GlobalConstants.SESSION_KEY_SYSTEMID,
		// systemId);

		// 调试时使用代码----------------------
		//String debugUserId = request.getParameter("debugUserId");
		//if (loginUnCheckSwitch && StringUtils.isNotBlank(debugUserId) && NumberUtils.isDigits(debugUserId)) {
			// UserVO user = userInfoCache.get(debugUserId);
			// if (user != null) {
			Subject currentUser = SecurityUtils.getSubject();
			// ShiroExtToken shiroExtToken = user.copyPropertiesTo(new ShiroExtToken());
			ShiroExtToken shiroExtToken = new ShiroExtToken();
			shiroExtToken.setCache(true);
			currentUser.login(shiroExtToken);
			return true;
			// }
		//}
		// ----------------------

	}
	boolean debug = true;
	@Override
	public boolean preHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {

		if(debug)
			return true;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// 以下只处理token已登录状态 和无需登录的额外情况-------------------------------------
		if (authentication(request, response)) {
			return true;
		}
		// ----------------------------------------------------------------------------
		return super.preHandle(request, response);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String header = httpServletRequest.getHeader(HttpHeaders.ACCEPT);

		if (StringUtils.contains(header, "application/json")) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("errorCode", "-1");
			jsonObject.put("errorMessage", "未登录");
			PrintWriter out = null;
			HttpServletResponse res = (HttpServletResponse) response;
			try {
				res.setCharacterEncoding("UTF-8");
				res.setContentType("application/json");
				out = response.getWriter();
				out.println(jsonObject);
			} catch (Exception e) {
			} finally {
				if (null != out) {
					out.flush();
					out.close();
				}
			}
			return false;
		} else {
			return super.onAccessDenied(request, response);
		}
	}

	@Bean
	public FilterRegistrationBean<ShiroAuthorizationFilter> registration(ShiroAuthorizationFilter filter) {
		FilterRegistrationBean<ShiroAuthorizationFilter> registration = new FilterRegistrationBean<ShiroAuthorizationFilter>(filter);
		registration.setEnabled(false);
		return registration;
	}

	protected void cleanup(ServletRequest request, ServletResponse response, Exception existing)
			throws ServletException, IOException {
		Exception exception = existing;
		if (exception instanceof RuntimeException) {
			throw (RuntimeException) exception;
		}
		super.cleanup(request, response, existing);
	}

}
