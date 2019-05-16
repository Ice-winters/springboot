package com.ice.springboot.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @Auther: Ice-winters
 * @Date: 2019/5/16 21:28
 * @Description:
 */
@Configuration
public class UploadConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofMegabytes(1));
        factory.setMaxRequestSize(DataSize.ofMegabytes(10));
        factory.setLocation("/temp/");

        return factory.createMultipartConfig();

    }
}
