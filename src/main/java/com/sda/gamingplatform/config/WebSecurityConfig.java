package com.sda.gamingplatform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	//w tej klasie definiujemy dostępy do podstron dla użytkowników o konkretnych rolach

	private DataSource datasource;

	@Autowired
	public WebSecurityConfig (DataSource dataSource) {
		this.datasource = dataSource;
	}


	//TODO permit all roulette for tests
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
				authorizeRequests()
				.antMatchers("/", "/index", "/register", "/login")
				.permitAll()
				.antMatchers("/adminmanager")
				.hasRole("ADMIN")
				.antMatchers("/gameroom")
				.hasRole("USER")
				.antMatchers("/roulette")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll();
		http.csrf().disable();
	}

	//here method to authenticate users


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource)
				.usersByUsernameQuery("select username, password, TRUE from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");

	}
}
