package com.ice.springboot.config;

import com.ice.springboot.interceptors.CustomHandlerInterceptor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: Ice-winters
 * @Date: 2019/4/25 21:21
 * @Description:
 */
@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer customMvcConfigurerAdapter (){

        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new CustomHandlerInterceptor()).addPathPatterns("/**");
                // 添加拦截器
//                super.addInterceptors(registry);
            }
        };
    }

}
