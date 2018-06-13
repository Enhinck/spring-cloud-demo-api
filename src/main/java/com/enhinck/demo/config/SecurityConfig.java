package com.enhinck.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**", "/index").permitAll()
		.antMatchers("/user/**").hasRole("USER")
				.and()
				.formLogin()
				.loginProcessingUrl("")
				.loginPage("/login")
				.failureUrl("/login-error");

		String[] cookieNamesToClear = new String[] {};

		http.logout().logoutUrl("/my/logout").logoutSuccessUrl("/my/index")
				.logoutSuccessHandler(new LogoutSuccessHandler() {

					@Override
					public void onLogoutSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
							throws IOException, ServletException {
						// TODO Auto-generated method stub

					}
				}).invalidateHttpSession(true).addLogoutHandler(new LogoutHandler() {

					@Override
					public void logout(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2) {
						// TODO Auto-generated method stub

					}
				}).deleteCookies(cookieNamesToClear).and();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}
}
