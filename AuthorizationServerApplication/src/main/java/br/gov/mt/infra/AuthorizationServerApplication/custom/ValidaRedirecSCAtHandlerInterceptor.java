package br.gov.mt.infra.AuthorizationServerApplication.custom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class ValidaRedirecSCAtHandlerInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		validaRedirectSCA(request, response,handler);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	private void validaRedirectSCA(HttpServletRequest request, HttpServletResponse response, Object handler) {
		request.getParameter("redirect_uri");
		request.getParameter("redirect_uri");
		request.getParameter("redirect_uri");
		request.getParameter("redirect_uri");
		request.getParameter("redirect_uri");
		
	}
}
