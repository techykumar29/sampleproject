package com.example.filter.config;

import java.util.function.BiPredicate;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.filter.filters.approac1.MyFilter3;

@Configuration
public class AppConfig {
	

    @Bean
    FilterRegistrationBean<MyFilter3> filter3() {
        FilterRegistrationBean<MyFilter3> filterRegBean = new FilterRegistrationBean<>();
        filterRegBean.setFilter(new MyFilter3());
        filterRegBean.setOrder(3);
//		filterRegBean.setUrlPatterns(null);
        return filterRegBean;
    }
    
    @Bean
    @Conditional(AppSecurity.class)
    Object getInMemoryConfiguration() {
    	System.out.println("Condition based bean injection");
    	return new Object();
    }

}
