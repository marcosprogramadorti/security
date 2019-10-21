package br.gov.mt.infra.AuthorizationServerApplication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
@Component
public class CustomLogoutHandler implements LogoutHandler {
	@Autowired
    private CustomAuthenticationProvider authProvider;
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		System.out.println("Logout realizado com sucessso");
		authentication.setAuthenticated(false);
		authProvider.authenticate(authentication);
		
		
	}



	

}
