package com.ice.springboot.config;

import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * @Auther: Ice-winters
 * @Date: 2019/4/26 07:06
 * @Description:
 */
@Configuration
public class ErrorPageConfig {

//    @Bean
////    public EmbeddedServletContainerCustomizer
//    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
//
//        return factory -> {
//            System.out.println("");
//            ErrorPage errorPage = new ErrorPage();
//
//            factory.addErrorPages();
//        };
//    }
}
