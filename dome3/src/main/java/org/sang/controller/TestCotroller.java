package org.sang.controller;

import org.sang.model.Book;
import org.sang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestCotroller {

//    @Autowired
//    Book book;
    @Autowired
    User book;
    @GetMapping("/book")
//    @ResponseBody
    public String hello(){
        System.out.println("我们的"+"===="+book.getBooks());
        return "我们！"+book.toString();
//        return book.toString();
    }
}
