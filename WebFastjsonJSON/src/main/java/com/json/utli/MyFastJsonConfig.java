package com.json.utli;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class MyFastJsonConfig {
    /**
     * 需要在配置文件properties加入spring.http.encoding.force-response=true防止输出json乱码
     * @return
     */
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd");
        config.setCharset(Charset.forName("UTF-8"));
        config.setSerializerFeatures(
                SerializerFeature.WriteClassName,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty
        );//17到25行分别配置了JSON解析过程的一些细节，如日期格式、数据编码、是否存在JSON中出处类名
//        是否输出value为null的数据、生成的JSON的格式。空集合输出[]而非null、空字符窜输出”“而非null的
//               该类配置完成后，需要在配置文件中配置格式编码，否则返回的JSON出现中文乱码，properties文件
        converter.setFastJsonConfig(config);
        return converter;

    }
}
    /**
     * 下面方法与上面方法内容基本一致，先变多加接口WebMvcConfigurer，另外创建一个类复制代码进去
     *
     * 如果某一项自动化配置不满足开发需求，开发者可以针对该项自定义配置，
     * 只需要实现WebMvcConfigurer 接口即可（在spring5.0之前是通过继承
     * WebMvcConfigurerAdapter类来实现的。
     *
     */
//@Configuration
//public class MyWebMvcConfig implements WebMvcConfigurer {
//     @Override
//     public void configureMessageConverters(List<HttpMessageConverter <?>>
//                converters) {
//         FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//         FastJsonConfig config = new FastJsonConfig();
//         config.setDateFormat("yyyy-MM-dd");
//         config.setCharset(Charset.forName("UTF-8"));
//         config.setSerializerFeatures(
//                 SerializerFeature.WriteClassName,
//                 SerializerFeature.WriteMapNullValue,
//                 SerializerFeature.PrettyFormat,
//                 SerializerFeature.WriteNullListAsEmpty,
//                 SerializerFeature.WriteNullStringAsEmpty
//         );
//         converter.setFastJsonConfig(config);
//         converters.add(converter);
//
//     }
//}
//}
