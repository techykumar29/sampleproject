package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer //implements WebApplicationInitializer
{

	//@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("App Initialized");
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
//		dispatcherServlet.setApplicationContext(context);
		
		ServletRegistration.Dynamic customDispatcher = servletContext.addServlet("myDispatcher", dispatcherServlet);
		customDispatcher.setLoadOnStartup(1);
		customDispatcher.addMapping("/mywebb/*");
		
	}

}
