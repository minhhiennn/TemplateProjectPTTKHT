package com.laptrinhjavaweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.service.HomeService;


// Sử dụng để 
public class MenuHandleIntercetor implements HandlerInterceptor {

	@Autowired
	private HomeService homeService;
	
	@Override
	// Trước khi request vào URL controller thì chạy thằng này trước
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("menu", homeService.loadMenu());
		return true;
	}

	@Override
	// Trong khi ...
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	// Sau khi ....
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
