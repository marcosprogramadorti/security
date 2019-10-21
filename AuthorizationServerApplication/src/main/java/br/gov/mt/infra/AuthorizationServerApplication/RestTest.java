package br.gov.mt.infra.AuthorizationServerApplication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/publico")
public class RestTest {
	
	
	@Autowired
    private CustomLogoutHandler customLogoutHandler;
	
	@GetMapping("/teste")
	public String teste (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("teste");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		customLogoutHandler.logout(request, response, authentication);
		return "teste ok";
	}
	
}
