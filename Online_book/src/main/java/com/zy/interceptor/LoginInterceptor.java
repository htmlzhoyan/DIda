package com.zy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		// 获取访问的资源的路径
		String uri = request.getRequestURI();
		// 如果是和登录相关的资源，直接放行
		if(uri.contains("login")||uri.contains("register")
			||uri.contains(".css")||uri.contains(".js")	
				){
			return true;
		}else{
			// 其他资源需要判断session中是否记录了状态，如果有，说明已经登录，可以直接放行
			// 如果没有，需要跳转到登录界面
			HttpSession session = request.getSession();
			String name = (String)session.getAttribute("user");
			if(name == null || name.isEmpty() ){
				response.sendRedirect(request.getContextPath() + "/login.html");
				return false;
			}
			return true;
		}
		
	}

}
