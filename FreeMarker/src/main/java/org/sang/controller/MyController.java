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
        System.out.println("输出0");
        Book b2 = new Book();
        b2.setId (2);
        b2.setAuthor("曹雪芹");
        b2.setName("红楼梦");
        books.add (b1);
        books.add (b2) ;

        ModelAndView mv =new ModelAndView();
        System.out.println("输出1===");
        mv.addObject("books", books) ;//前台获取值时用到
        System.out.println("输出2====");
        mv.setViewName ("books");//视图名称，也就是返回html的名字
        System.out.println("输出23");
        return mv;
    }
}
