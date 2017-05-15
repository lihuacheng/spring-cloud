package com.alimaomao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/security/test")//配置不需要安全控制的URL
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
		.formLogin()
			.loginPage("/security/login")
			.permitAll()
			.and()
			.logout()
			.permitAll();
		
	}
}
