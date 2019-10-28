package br.gov.mt.infra.AuthorizationServerApplication.custom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class RefererRedirectionAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler
		implements AuthenticationSuccessHandler {

	public RefererRedirectionAuthenticationSuccessHandler() {
		
		super();	
	}
	
	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		request.getAttributeNames();
		return super.determineTargetUrl(request, response);
	}
	
	@Override
	protected RedirectStrategy getRedirectStrategy() {
		getRedirectStrategy().toString();
		return super.getRedirectStrategy();
	}
	@Override
	protected String getTargetUrlParameter() {
		getTargetUrlParameter().toString();
		return super.getTargetUrlParameter();
	}
	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {
		request.getParameterNames();
		return super.determineTargetUrl(request, response, authentication);
	}

}
