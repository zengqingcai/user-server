package com.user.base.interceptor;


import com.user.base.annotation.TestAccess;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//https://www.cnblogs.com/zengcheng623/p/10736947.html
@Service
public class AccessInterceptor extends HandlerInterceptorAdapter{
	

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod)handler;
			if(hm.hasMethodAnnotation(TestAccess.class)){
				System.out.println("hhhhhhh");
			}
			TestAccess testAccess = hm.getMethodAnnotation(TestAccess.class);
			if(testAccess == null) {
				return true;
			}
			System.out.println("测试内容:"+testAccess.value());
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if(handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod)handler;
			if(hm.hasMethodAnnotation(TestAccess.class)){
				System.out.println("hhhhhhh");
			}
			TestAccess testAccess = hm.getMethodAnnotation(TestAccess.class);
			if(testAccess == null) {
//				return true;
			}
			//System.out.println("测试内容:"+testAccess.value());
		}

	}
}
