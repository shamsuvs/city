package com.smashplus.cityxplor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class AppConfig implements WebMvcConfigurer {
//public class AppConfig{
   /* @Autowired
    AuthenticationInterceptor authenticationInterceptor;
    @Autowired
    UserInterceptor userInterceptor;
    //@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/auth/login/validate");
        registry.addInterceptor(userInterceptor).addPathPatterns("/**").excludePathPatterns("/img/**","/js/**","/css/**","/fonts/**","/error");;
    }*/

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/sitemap.xml").addResourceLocations("/seo/");
        registry.addResourceHandler("/robots.txt").addResourceLocations("/seo/");
        registry.addResourceHandler("/ads.txt").addResourceLocations("/seo/");
    }
}
