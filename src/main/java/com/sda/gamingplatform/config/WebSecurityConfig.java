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


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
				authorizeRequests()
				.antMatchers("/", "/home", "/register")
				.permitAll()
				.antMatchers("/adminmanager")
				.hasRole("ADMIN")
				.antMatchers("/gameroom")
				.hasRole("USER")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/")
				.permitAll()
				.and()
				.logout()
				.permitAll();
	}

	//here method to authenticate users


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource)
				.usersByUsernameQuery("select username, password from users where username=?");
	}
}
