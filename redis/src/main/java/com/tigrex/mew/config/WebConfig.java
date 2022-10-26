package com.tigrex.mew.config;

import com.tigrex.mew.interceptor.MewInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author linus
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public MewInterceptor bodyInterceptor(){
        return new MewInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bodyInterceptor()).addPathPatterns("/**");
    }
}
