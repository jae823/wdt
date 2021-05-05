package co.kr.wdt.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// session 처리
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("authUser") == null) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		
		if (session.getAttribute("admin") == null) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		
		if (session.getAttribute("authUser") != null && session.getAttribute("admin").equals("admin")) {
			return true;	
		}
		
		return false;
	}

}