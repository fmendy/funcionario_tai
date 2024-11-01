package com.funcionario.tai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		/*
		 * return http.csrf().disable().authorizeHttpRequests().requestMatchers("/",
		 * "/login").permitAll().and()
		 * .authorizeHttpRequests().requestMatchers("/**").authenticated()
		 * 
		 * .and().formLogin().and().build();
		 */

		return http.csrf().disable().build();

	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {

		// InMemoryUserDetailsManager
		UserDetails admin = User.withUsername("ADMIN_TAI_OPE_2022").password(encoder.encode("123"))
				.roles("ADMINISTRADOR").build();

		UserDetails user = User.withUsername("FUNCI_TAI").password(encoder.encode("2022")).roles("FUNCIONARO").build();

		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService(passwordEncoder()));
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

}
