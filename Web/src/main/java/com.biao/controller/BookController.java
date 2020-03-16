package com.biao.controller;

import com.biao.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
/*
 *用本机ie浏览器，出现乱码，谷歌正常
 */
@RestController
public class BookController {
//    @Autowired //使用时，直接在要用到的类上添加@Component扫描注解，就可以直接使用了
//    Book b1;
    @GetMapping("/booksWeb")
    @ResponseBody//该注解可以不使用，@RestController为Controller与@ResponseBody两个的组合
    public Book book(){
         //使用时，直接在要用到的类上添加@Component扫描注解，就可以直接使用了
         //Book b1;
        Book b2 = new Book();
        b2.setAuthor("我是web作者");
        b2.setName("我是作者");
        b2.setPrice(30f);
        b2.setDate(new Date());
        return b2;
    }
}
