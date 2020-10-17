package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc
@ComponentScan(basePackages="com.spring")
public class SpringConfiguration extends WebMvcConfigurerAdapter{
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		/*UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);*/
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
/*	@Bean
	public TilesConfigurer tilesConfigure() {
		TilesConfigurer tilesConfigure = new TilesConfigurer();
		tilesConfigure.setDefinitions(new String[] {"WEB-INF/tiles.xml"});
		tilesConfigure.setCheckRefresh(true);
		return tilesConfigure;
	}
	*/

/*	@Bean
	public ViewResolver  getViewResolver(){
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}*/
	
}