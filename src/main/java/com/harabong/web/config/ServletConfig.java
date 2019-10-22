package com.harabong.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {"com.hanrabong.web.controller"})
public class ServletConfig implements WebMvcConfigurer{
	
	
	  public void configureViewResolvers(ViewResolverRegistry registry) {

		  InternalResourceViewResolver bean = new InternalResourceViewResolver();
		  bean.setViewClass(JstlView.class);
		  bean.setPrefix("/WEB-INF/Views/");
		  bean.setSuffix(".jsp");
		  registry.viewResolver(bean);
		  
	        
	    }
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  registry.addResourceHandler("/resources/**")
		  .addResourceLocations("/resources/");
		  
		  
	    }

	
}
