package com.project.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import com.project.filter.JWTValidationFilter;
import com.project.session.Session;

@Configuration
public class FilterConfig {
//	public static final String OWNER_PATH = "/review/*";
	public static final String CUSTOMER_PATH = "/reviews/customer/*";
	
	Session session = Session.getSession();
	
	@Bean
	public FilterRegistrationBean<GenericFilterBean> jwtFilter(){
		FilterRegistrationBean<GenericFilterBean> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JWTValidationFilter());
		filterRegistrationBean.addUrlPatterns(CUSTOMER_PATH);
		
//		if(session.getRole().equalsIgnoreCase("customer")) {
//			filterRegistrationBean.addUrlPatterns(CUSTOMER_PATH);
//		} else if(session.getRole().equalsIgnoreCase("owner")){
//			filterRegistrationBean.addUrlPatterns(OWNER_PATH);
//		} else {
////			filterRegistrationBean.addUrlPatterns("");
//		}
		return filterRegistrationBean;
	}
	
}
