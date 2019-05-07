package com.ice.springboot.config;

import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import javax.servlet.DispatcherType;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Ice-winters
 * @Date: 2019/4/26 07:06
 * @Description:
 */
@Configuration
public class ErrorPageConfig {

    @Bean
////    public EmbeddedServletContainerCustomizer
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return factory -> {
            // 注意这里要加上.html后缀  默认走的static下内容
            ErrorPage errorPage_400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/errorpages/error-400.html");
            ErrorPage errorPage_404 = new ErrorPage(HttpStatus.NOT_FOUND, "/errorpages/error-404.html");
            ErrorPage errorPage_405 = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/errorpages/error-405.html");
            ErrorPage errorPage_500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errorpages/error-500.html");
            /*List<ErrorPage> errorPages = Arrays.asList(new ErrorPage(HttpStatus.BAD_REQUEST, "error-400"),
                    new ErrorPage(HttpStatus.NOT_FOUND, "error-404"),
                    new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "error-500"));*/
            factory.addErrorPages(errorPage_400, errorPage_404, errorPage_405, errorPage_500);
        };
    }

//    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactoryCustomizer() {
//        return factory -> {
//            factory.addErrorPages();
//        };
//    }

}
