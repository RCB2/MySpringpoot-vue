package com.gson.utli;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Configuration
public class GsonConfig {
    @Bean
    GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd");//设置Gson解析时日期的格式
//        builder.excludeFieldsWithModifiers(Modifier.PROTECTED);// protected Float price;protected定义的该字段被过滤掉
        Gson gson = builder.create();//创建对象，放入GsonHttpMessageConverter的实例中并返回converter
        converter.setGson(gson);
        return converter;
    }
//    或者
//    @Bean
//    @ConditionalOnMissingBean
//    public GsonHttpMessageConverter gsonHttpMessageConverter(Gson gson){
//        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
//        converter.setGson(gson);
//        return converter;
//    }
}
