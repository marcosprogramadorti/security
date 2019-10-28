package br.gov.mt.infra.AuthorizationServerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.gov.mt.infra.AuthorizationServerApplication.custom.RefererRedirectionAuthenticationSuccessHandler;
@Configuration
@Order(1)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
    private CustomAuthenticationProvider authProvider;
	
    @Value("${user.oauth.user.username}")
    private String username;
    @Value("${user.oauth.user.password}")
    private String password;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.authorizeRequests()
        	.antMatchers("/publico**","/login", "/oauth/authorize")
        	.permitAll()
        	.and()
        	.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            //.formLogin().permitAll().successHandler(new RefererRedirectionAuthenticationSuccessHandler());
            .formLogin().permitAll();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.authenticationProvider(authProvider);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}