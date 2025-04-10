package sg.edu.nus.team3.shoppingcart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sg.edu.nus.team3.shoppingcart.interceptor.LoginInterceptor;

@Component
public class WebAppConfig implements WebMvcConfigurer {
	@Autowired
	LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// Current interceptor implementation redirects to login from ALL URLs except Login itself, if not logged in.
		registry.addInterceptor(loginInterceptor).addPathPatterns("/*").excludePathPatterns("/login");
	}
	
	
}