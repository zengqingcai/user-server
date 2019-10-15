//package com.user.base.config;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import javax.servlet.http.HttpServletRequest;
//import java.util.Enumeration;
//
//public class FeignClientInterceptor implements RequestInterceptor {
//	@Override
//	public void apply(RequestTemplate requestTemplate) {
//		//拦截器
//		//使用RequestContextHolder工具获取request相关变量
//		try {
//			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
//					.getRequestAttributes();
//			if (attributes != null) {
//				//取出request
//				HttpServletRequest request = attributes.getRequest();
//				//取出所有请求头
//				Enumeration<String> headerNames = request.getHeaderNames();
//				while (headerNames.hasMoreElements()) {
//					String name = headerNames.nextElement();
//					// key
//					String value = request.getHeader(name);
//					//value
//					if (name.equals("authorization")) {
//					//auoth2 认证请求头
//					//System.out.println("name="+name+"values="+values);
//						requestTemplate.header(name, value);
//					}
//				}
//			}
//		} catch (Exception e) {
//		}
//	}
//}