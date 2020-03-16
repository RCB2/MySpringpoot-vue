//package com.cosr.controller;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// *全局配直需要自定义类实现 WebMvcConfigurer 接口，然后实现接口中的 addCorsMappings
// * 方法。
// * ·在 addCorsMappings 方法中， addMapping 表示对哪种格式的请求路径进行跨域处理；
// * allowedHeaders 表示允许的请求头，默认允许所有的请求头信息； allowedMethods 表示九许
// * 的请求方法，默认是 GET POST HEAD; ＊表示支持所有的请求方法； max.Age 表示探测
// * 请求的有效期； allowedOrigins 示支持的域
// *
// * 在上面的两种配置方式（ @CrossOrigin 注解配置和全局配置）中，选择其中一种即可，然
// * 后启动项目。
// *
// *
// * 类中的该方法或许需要使用Thymeleaf模板，或许配合注解@Configuration
// */
//@Configuration
//public class BookController2 implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        System.out.println("进入1");
//        registry.addMapping("/book/**")//表示对哪种格式的请求路径进行跨域处理；
//        .allowedHeaders("*")//默认允许所有的请求头信息
//        .allowedMethods("*")//＊表示支持所有的请求方法
//        .maxAge(1800)//表示探测 请求的有效期
//        .allowedOrigins("http://localhost:8080");//示支持的域
//        System.out.println("进入2");
//     }
//}
