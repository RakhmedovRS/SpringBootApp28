package com.github.rakhmedovrs.SpringBootApp28.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author RakhmedovRS
 * @created 08-Mar-20
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
	{
		authenticationManagerBuilder.inMemoryAuthentication()
			.withUser("in28Minutes")
			.password("{noop}dummy")
			.roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
			.antMatchers("/login")
			.permitAll()
			.antMatchers("/", "/*todo*/**")
			.access("hasRole('USER')")
			.and()
			.formLogin();
	}
}
