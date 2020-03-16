//package com.sc.utli;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.support.StandardServletMultipartResolver;
//import org.springframework.web.servlet.DispatcherServlet;
//
///**
// *自动配置
// * java中的文件上传涉及到两个组件，一个是CommonsMultipartResolver
// * 另外一个是StandardServletMultipartResolver，其中前者使用Commons-fileupload
// * 来处理mulipart请求，后者则是基于Server3.0处理该请求，因此不需要额外添加jar包
// * comcat7.0开始支持
// *
// * 跟具下面的配置知道，开发者没有提供MultipartResolver，那么默认采用
// * 的MultipartResolver就是StandardServletMultipartResolver。
// * 因此在spring boot中上传文件甚至可以做到零配置。
// */
//public class MultiparAutoConfiguration {
//
//
//    @Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
//    @ConditionalOnMissingBean(MultipartResolver)
//    public StandardServletMultipartResolver multipartResolver(){
//        StandardServletMultipartResolver multipartResolver = new
//                StandardServletMultipartResolver();
//        multipartResolver.setResolveLazily(this.multipartProperties.isResolveLazily);
//        return multipartResolver;
//    }
//}
