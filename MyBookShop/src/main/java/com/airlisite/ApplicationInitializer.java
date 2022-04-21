/**
 * AdminApplicationInitializer.java
 *
 * 功能： （用一句话描述类的功能）
 * 类名：  AdminApplicationInitializer
 */
package com.airlisite;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.airlisite.config.AppConfig;
import com.airlisite.config.DispatcherConfig;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @version Ver 1.0 2020年2月13日
 * @since Ver 1.0
 */
public class ApplicationInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext container) throws ServletException {
		// Create the 'root' Spring application context
		 AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		 rootContext.register(AppConfig.class);
		
	     // Manage the lifecycle of the root application context
	     container.addListener(new ContextLoaderListener(rootContext));
	 
	     // Create the dispatcher servlet's Spring application context
	     AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
	     dispatcherContext.register(DispatcherConfig.class);
	
	     // Register and map the dispatcher servlet
	     ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
	     dispatcher.setLoadOnStartup(1);
	     dispatcher.addMapping("/");
	}
}
