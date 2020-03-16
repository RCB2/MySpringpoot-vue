package com.cosr.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    /**
     * JSONP只支持GET请求
     * cosr支持，支持多种HTTP请求方法
     * @param name
     * @return
     * 下面两个方法提供了两个接口，添加接口和删除接口
     * 配置跨域：有两种方法配置，一个是直接在相应的请求方法上加上注解：@CrossOrigin()
     * 另外一个是采用全局配置:BookController2//这种方法不用每个方法都添加@CrossOrigin注解
     */
//      @RequestMapping("/book")//只要有这一行就能访问该方法
    @PostMapping("/")
//    @CrossOrigin(value = "http://localhost:8080",maxAge = 1800,allowedHeaders = "*")
     public String addBook (String name) {
        System.out.println("添加");
        return "receive:" + name;
    }

    /**
     * @CrossOrigin 中的value表示支持的域。
     * 这里表示来自http://localhost:8080域的请求时支持跨域的域
     * maxAge表示探测请求挺有效期，1800秒，不用每次发送，有效期过后才会发送探测请求
     * allowedHeaders表示允许的请求头，*表示所有的请求头都被允许
     * @param id
     * @return
     */
//    @RequestMapping("/book2")
    @DeleteMapping("/{id}")//这个id
//    @CrossOrigin(value = "http://localhost:8080",maxAge = 1800,allowedHeaders = "*")
    public String deleteBookByid(@PathVariable Long id) {
        System.out.println("删除");
        return String.valueOf(id);
    }
}
