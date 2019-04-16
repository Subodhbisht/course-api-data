package io.course.springboot.security;

import io.course.springbootstarter.service.UserInfoDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserInfoDetails userInfoDetails;
	
//	Authentication User & their roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
//		auth.inMemoryAuthentication().withUser("subodh").password("bisht").roles("ADMIN","USER").and()
//		.withUser("priyanka").password("vaid").roles("USER");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userInfoDetails).passwordEncoder(passwordEncoder);
	}
	
//	Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.POST).hasRole("ADMIN").antMatchers("/topics**").hasAnyRole("ADMIN","USER")
		.and().csrf().disable().headers().frameOptions().disable();
	}
}
