package com.vikas.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ContactApplicationDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{SpringRootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{SpringWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}

	@Override 
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext); //must present
		//Configure global task here if required
	}
}
