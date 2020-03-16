package com.sc.controller;

import com.sc.model443.Author;
import com.sc.model443.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @ControllerAdvice 结合@InitBinder还能实现请求
 * 参数预处理，即将表单中的数据绑定到实体类上时进行一些额外处理
 *
 */
@RestController
public class Controller443 {
    /**
     * 在controller中需要接收两个实体类的数据，controller中的方法定义
     * @param book
     * @param author
     * @return
     */
    @GetMapping("/book")
//    @ResponseBody
    public String book(Book book, Author author){
//        book.setName("没有去区别两个实体类的name");
        return book.toString()+">>>>>>"+author.toString();
    }
    /**
     * 上面的方法中
     * 在参数传递时，Book与Author两个实体类中的name属性会混希，
     * @ControllerAdvice结合@InitBinder可以顺利解决该问题
     *下面配置方法，解决该问题
     * 添加注解@ModelAttribute
     */
    @GetMapping("/book2")
//    @ResponseBody
    public String book2(@ModelAttribute("b") Book book,@ModelAttribute("a") Author author){

        book.setName("阮春彪");
        book.setAuthor("开场即巅峰");
        System.out.println("进入Controller443,处理完a与b后");
        return book.toString()+">>>>>>"+author.toString();

    }
}
