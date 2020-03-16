package com.jtzyfw.utli;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.jtzyfw.utli.WebMvcProperties.getResourceLocations;
import static jdk.nashorn.internal.objects.NativeDate.getSeconds;
import static org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.getResourceLocations;

//继承   默认策略
@Configuration
public class Resourece implements WebMvcConfigurer {

    private WebMvcProperties mvcProperties;
    private ResourceProperties resourceProperties;
    private Object cachePeriod;
    private CacheControl cacheControl;

    public void addResourceHandlers (ResourceHandlerRegistry registry) {

        String staticPathPattern = this.mvcProperties.getStaticPathPattern();
        if (!registry.hasMappingForPattern(staticPathPattern)) {
            customizeResourceHandlerRegistration(
                    registry.addResourceHandler(staticPathPattern)
                            .addResourceLocations(getResourceLocations(
                                    //下面这句获取到的默认静态资源位置定义在ResourceProperties中
                                    this.resourceProperties.getStaticLocations()))
                            .setCachePeriod(getSeconds(cachePeriod))
                            .setCacheControl(cacheControl));
        }
    }
}
