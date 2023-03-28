package com.shop.config;

import com.shop.iterceptor.LoginContextInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义配置类
 *
 * @author 祝明
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public LoginContextInterceptor loginContextInterceptor() {
        return new LoginContextInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginContextInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/swagger-ui.html",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/user/info/login",
                        "/user/info/create");

    }

}
