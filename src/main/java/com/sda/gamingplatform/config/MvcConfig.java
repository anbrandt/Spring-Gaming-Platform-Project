//
//package com.sda.gamingplatform.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//
//@Configuration
//@EnableWebMvc
//public class MvcConfig extends WebMvcConfigurerAdapter {
//
//	//tutaj znajdują się odniesienia do podstron bezstanowych - konkretnym urlom przypisujemy podstronę html
//
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/")
//				.setViewName("index");
//		registry.addViewController("/home")
//				.setViewName("index");
//		registry.addViewController("/login")
//				.setViewName("login");
//		registry.addViewController("/gameroom")
//				.setViewName("gameroom");
//
//registry.addViewController("/index2")
//				.setViewName("index2");
//
//
//registry.addViewController("/roulette")
//				.setViewName("roulette");
//
//
//	}
//
////	public void addResourceHandlers(ResourceHandlerRegistry registry) {
////		registry.addResourceHandler("/js*/.addResourceLocations("/js/");
////	}
//
//
//}
