package com.ym.cms.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置映射路径
 */
@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private FileProperties fileProperties;
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(fileProperties.getStaticAccessPath()).addResourceLocations("file:"+fileProperties.getUploadFileFolder()+"/");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:d:/file/");
    }
}
