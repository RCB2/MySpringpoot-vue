package com.controller;

import com.serverlet.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 执行路径，Controller到service到aop切面的方法，通过，
 * 进入service的方法中执行需要执行的方法
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getId")
    public String getUserById(Integer id){
        System.out.println("Controller: get获取");
        return userService.getUserById(id);
    }

    @GetMapping("/deleteId")
    public void deleteUserById(Integer id){
        System.out.println("Controller: 删除");
        userService.deleteUserById(id);//userService中该被调用的方法没有返回值，这里也就没有返回值
    }
}
