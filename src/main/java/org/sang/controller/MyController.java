package org.sang.controller;

//import org.sang.model.Book;
import org.sang.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MyController {
//    @Autowired
//    Book books;
//    @GetMapping("/hello")
//    public String toString() {
//        return "我们"+ books.toString();
//    }
    @Autowired
    Book b1;
    @GetMapping("/books")
    public ModelAndView books(){

        List<Book> books = new ArrayList<>();
//        Book b1 = new Book();
//        b1.setId(1);
//        b1.setAuthor("真实的");
//        b1.setName("我都是第一的");

        Book b2 = new Book();
        b2.setId (2);
        b2.setAuthor("曹雪芹");
        b2.setName("红楼梦");
        books.add (b1);
        books.add (b2) ;

        ModelAndView mv =new ModelAndView();
        mv.addObject("books", books) ;
        mv.setViewName ("books" );
        return mv;
    }
}
