package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.spring")
public class TilesConfig extends WebMvcConfigurerAdapter{

	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		System.out.println("inside addResourceHandler^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}*/
	
	@Bean
	public TilesConfigurer tilesConfigure() {
		TilesConfigurer tilesConfigure = new TilesConfigurer();
		//tilesConfigure.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
		tilesConfigure.setDefinitions("/WEB-INF/tiles.xml");
		tilesConfigure.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
		tilesConfigure.setCheckRefresh(true);
		return tilesConfigure;
	}
	
	@Bean
	public ViewResolver  getViewResolver(){
	//	UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		TilesViewResolver viewResolver = new TilesViewResolver();
		//viewResolver.setViewClass(TilesView.class);
	//	viewResolver.setPrefix("/WEB-INF/layout/");
	//	viewResolver.setPrefix("");
		//viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}

