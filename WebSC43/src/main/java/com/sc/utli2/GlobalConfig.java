package com.sc.utli2;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice//全局数据处理
public class GlobalConfig {
    /**
     *4.4.2 添加全局数据
     *
     * 源码是另外创建一个类GlobalConfig,将下面的方法写到此类中
     *
     *返回值为Model类型，
     * @ControllerAdvice是一个全局数据处理组件，为此在他中配置全局数据，
     * 使用@ModelAttribute注解进行配置
     */
    /**
     * 在全局配置中添加userInfo方法，返回一个map。该方法有注解@ModelAttribute，
     * 其中的value属性表示这条返回数据的key,而方法的返回值是返回数据的value值
     *
     * 此时在任意请求的controller中，通过方法参数中的Model
     * 都可以获取info的数据
     * @return
     */
    @ModelAttribute(value = "info")
    public Map<String,String> userInfo(){
        HashMap<String,String> map = new HashMap<>();
        map.put("username","阮春彪");
        map.put("gender","性别男");
        return map;
    }
    /**
     * 4.4.3
     * 请求参数预处理结合两注解区别两实体类的name
     * 该类开头用到了@ControllerAdvice全局数据注解
     */
    @InitBinder("a")//a为@ModelAttribute("a")中的a，在控制类中。该注解表示处理注释@M...对应的参数
    public void inti(WebDataBinder binder){
        System.out.println("进入GlobalConfig类处理a 4.4.3");
        binder.setFieldDefaultPrefix("a.");//给它添加一个前缀，输出时为a.name=,这样就能区分两个实体类中的name属性
    }
    @InitBinder("b")//b为@ModelAttribute("b")中的b,在控制类,该注解表示处理注释@M...对应的参数
    public void inti2(WebDataBinder binder){
        System.out.println("进入GlobalConfig类处理b 4.4.3");
        binder.setFieldDefaultPrefix("b.");//给它添加一个前缀，输出时为a.name=,这样就能区分两个实体类中的name属性
    }
}
