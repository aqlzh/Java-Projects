/**
 * DispatcherConfig.java
 *
 * 功能： （用一句话描述类的功能）
 * 类名：  DispatcherConfig
 */
package com.airlisite.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.airlisite.exception.GlobalExceptionHandler;
/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @version Ver 1.0 2020年2月13日
 * @since Ver 1.0
 */
@Configuration
@ComponentScan(value = "com.airlisite",includeFilters={
		@Filter(type=FilterType.ANNOTATION,classes=Controller.class),
		@Filter(type=FilterType.ANNOTATION,classes=ControllerAdvice.class)
},useDefaultFilters=false)
@EnableWebMvc
public class DispatcherConfig extends WebMvcConfigurerAdapter{

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
		super.configureViewResolvers(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/admin/css/**").addResourceLocations("/admin/css/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
		super.addResourceHandlers(registry);
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		GlobalExceptionHandler exHandler = new GlobalExceptionHandler();
		exceptionResolvers.add(exHandler);
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}
	

}
