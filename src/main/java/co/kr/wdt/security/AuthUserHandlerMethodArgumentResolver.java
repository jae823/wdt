package co.kr.wdt.security;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.ModelAndViewContainer;

import co.kr.wdt.user.vo.UserVo;

public class AuthUserHandlerMethodArgumentResolver extends HandlerMethodArgumentResolverComposite {

	
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		Map<String, Object> userVo = new HashMap<String, Object>();
		
		if(!supportsParameter(parameter)) {
			return WebArgumentResolver.UNRESOLVED;	// 여기가 아닐때까지 다음 Resolver 호출
		}
				
		HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
		HttpSession session = request.getSession();
		if(session == null) {
			return null;
		}
		
		userVo.put("userNo", session.getAttribute("no"));
		userVo.put("userId", session.getAttribute("userId"));
		userVo.put("userNm", session.getAttribute("userNm"));
		userVo.put("userMajor", session.getAttribute("userMajor"));
		userVo.put("userSchool", session.getAttribute("userSchool"));
		userVo.put("userLevel", session.getAttribute("userLevel"));
		userVo.put("userPw", session.getAttribute("userPw"));
		
		return userVo;
	}
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		AuthUser authUser = parameter.getParameterAnnotation(AuthUser.class);
		
		// @AuthUser가 안붙어있는 경우
		if(authUser == null) {
			return false;
		}
				
		// 파라미터 타입이 UserVo가 아니면
		if(!parameter.getParameterType().equals(UserVo.class)) {
			return false;
		}
		
		return true;
	}



}
