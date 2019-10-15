package com.user.base.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

//@Component
//@WebFilter(filterName = "test", urlPatterns = "/*")
public class CommonFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("----------------------->过滤器被创建");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String requestURI = req.getRequestURI();
		System.out.println("--------------------->过滤器：请求地址" + requestURI);
		if (!requestURI.contains("info")) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.write("code=1001");
			writer.flush();
			writer.close();
		} else {
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		System.out.println("----------------------->过滤器被销毁");
	}

	

}
