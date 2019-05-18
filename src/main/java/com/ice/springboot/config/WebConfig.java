package com.ice.springboot.config;

import com.ice.springboot.interceptors.CustomHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                registry.addViewController("/upload").setViewName("fileUpload");
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("").allowedOrigins()
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new CustomHandlerInterceptor()).addPathPatterns("/**");
                registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
                // 添加拦截器
//                super.addInterceptors(registry);
            }
        };
    }


    class MyInterceptor implements HandlerInterceptor {

        Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            String methodName = handlerMethod.getMethod().getName();
//            logger.info("方法名字为===>"+ methodName);
            return true;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        }
    }

}
