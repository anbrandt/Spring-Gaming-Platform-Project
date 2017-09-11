package com.sda.gamingplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

	//tutaj znajdują się odniesienia do podstron bezstanowych - konkretnym urlom przypisujemy podstronę html

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/")
				.setViewName("index");
		registry.addViewController("/home")
				.setViewName("index");

	}
}
