package com.flores.util;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ConditionalOnProperty("my.securit.enabled")
//@EnableWebSecurity
@Import (SecurityAutoConfiguration.class)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	/*
	@Override
	protected void configure(HttpSecurity security) throws Exception{
		security.httpBasic().disable();
		security.cors().and().authorizeRequests().antMatchers("/usuario").hasRole("user")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
	*/
	
}
