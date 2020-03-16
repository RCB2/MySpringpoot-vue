package com.gson.controller;
import com.gson.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BookController {
//    @Autowired
//    Book b1;
    @GetMapping("/booksWeb2")
    @ResponseBody//该注解可以不使用，@RestController为Controller与@ResponseBody两个的组合
    public Book book(){
        Book b2 = new Book();

        b2.setAuthor("我是web作者");
        b2.setName("我是作者");
        b2.setPrice(30f);
        b2.setDate(new Date());
        return b2;
    }
}
