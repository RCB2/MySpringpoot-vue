package com.zdy.t;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 编码定义静态资源访问路径，现在有配置文件，注释该类
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry) {
                    registry
                           .addResourceHandler("/static/**")
                           .addResourceLocations("classpath:/static/");
                    registry
                            .addResourceHandler("/p/**")//浏览器输入
                            .addResourceLocations("classpath:/public/");

    }
}
