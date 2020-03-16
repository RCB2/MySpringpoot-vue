package com.sc.utli;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 4.5.2,
 * 该类处理的异常为404之类的异常。即容器级别的错误，如Filter中抛出异常
 * CustomExceptionHandler类中处理的是一些应用级别的异常
 * 类名改为 MyErrorAttribute
 *
 * 该类用Thymeleaf模板，默认先处理Thymeleaf目录下的
 * 若用户定义了多个幸如吴页面，则响应码.html 页面的优先级高于 4xx html 5xx.html 页面的
 * 优先级，即若当前是一个 4044白灵，则优先展示 404.html 而不是 4xx.h ；动态页面的优先
 * 级高于静态页面，即若 resources/templates resources/static 下同时定义了 4xx.htrr让，则优先
 * 展示 resources/templates/4xx.html
 *
 *Thymeleaf默认路径resources/templates，该类需要在resources/templates创建报错页面用于接收报错信息，现在暂时不创建
 */
@Component
public class CustomExceptionHandler452 extends DefaultErrorAttributes {
    @Override
    public Map<String,Object> getErrorAttributes(WebRequest webRequest , boolean
            includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest,
                includeStackTrace);
        errorAttributes.put("custommsg", "出错啦 ！");
        errorAttributes.remove("error");
        return errorAttributes;
    }
    /**
     * 学会4.5.2中第二种，自定义Error视图比较好，只需要创建一个error页面，无论404或500都会返回该页面，
     * 展示详细信息，也就该类上面的这一种方法
     */
}
