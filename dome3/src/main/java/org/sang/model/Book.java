package org.sang.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
//@ConfigurationProperties(prefix = "book0")
@Order(value = 1)
@Component
@ConfigurationProperties(prefix = "book0.user")
public class Book {
    /**
     * Spring Boot采用一种宽松规则进行属性绑定，如bean中属性名为authorName,
     * 那么配置文件属性可以是book0.author_name、book0.author-name、book0.authorName
     * book0.AUTHORNAME
     */

    private  String name;
    private  String password;
//    private  String price;//测试properties文件用的
    private List<String> price;//数组

//省略getter、setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getPrice() {
        return price;
    }

    public void setPrice(List<String> price) {
        this.price = price;
    }
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
