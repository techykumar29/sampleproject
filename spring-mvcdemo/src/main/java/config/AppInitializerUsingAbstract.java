package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializerUsingAbstract extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?>[] cls = {AppConfig.class};
		return cls;
	}

	@Override
	protected String[] getServletMappings() {
		String [] urls = {"/webapp/*"};
		return urls;
	}

}
