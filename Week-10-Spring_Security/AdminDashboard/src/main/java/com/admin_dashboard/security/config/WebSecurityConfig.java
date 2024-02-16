package com.admin_dashboard.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	
	private UserDetailsService userDetailsService;
	
	// Add BCrypt Bean
		@Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Bean
		protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
			
			http
				.authorizeRequests()
					.antMatchers("/css/**", "/register", "/login").permitAll()
					.antMatchers("/admin").access("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
					.antMatchers("/home").access("hasRole('USER')")
					.anyRequest().authenticated()
					.and()
				.formLogin()
					.loginPage("/login")
					.usernameParameter("email") // Use email instead of userName for login purposes
					.permitAll()
					.and()
				.logout()
					.permitAll();
		
			return http.build();
		}
	
	// configuring Spring Security to use our custom implementation of the UserDetailsService with Bcrypt
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    } 
}
