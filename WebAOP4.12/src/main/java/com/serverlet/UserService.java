package com.serverlet;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUserById(Integer id){
        System.out.println("UserService: 添加");
        return "我是获得方法";
    }
    public void deleteUserById(Integer id){
        System.out.println("UserService: 删除");
        System.out.println("我是删除service方法...");
    }
}
