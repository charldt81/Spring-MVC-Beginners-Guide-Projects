package com.packt.webstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.util.UrlPathHelper;



@Configuration							// this indicates that a class declares one or more @Bean methods
@EnableWebMvc							// Adding this annotation to an @Configuration class imports some special Spring MVC configuration
@ComponentScan("com.packt.webstore")	// This specifies the base packages to scan for annotated components (beans)
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter {

	
	@Override
	public void configureDefaultServletHandling (DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	// To enable the use of matrix variables in Spring MVC, we must set the RemoveSemicolonContent property of UrlPathHelper to false.
	// Here we are enabling matrix variable support by overriding the configurePathMatch method as follows:
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false);
		configurer.setUrlPathHelper(urlPathHelper);
	}
	
	
	// This is a '@Bean' from the 'org.springframework' and is imported as shown above.
	// We are instructing Spring MVC to create a bean for the class - InternalResourceViewResolver.
	// We configured InternalResourceViewResolver as our view resolver in the web application context configuration, 
	// during the process of resolving the view file for the given view name (in our case the view name is products), 
	// the view resolver will try to look for a file called products.jsp under /WEB-INF/views/.
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	
}