package org.sang;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new
                SpringApplicationBuilder(TestApplication.class);
//            去掉字样OFF
        builder.bannerMode(Banner.Mode.OFF).run(args);

//            SpringApplication.run(TestApplication.class, args);
        /**
         * 选择启动使用哪一个配置文件
         */
//            SpringApplicationBuilder builder = new
//                    SpringApplicationBuilder(TestApplication.class);
//            builder.application().setAdditionalProfiles("prod");
//            builder.run(args);
    }
}


//<!DOCTYPE html>
//<html lang="en" xmlns:th="http://www.thymeleaf.org">
//<head>
//<meta charset="UTF-8">
//<title>图书列表</title>
//</head>
//<body>
//<table border="1">
//<tr>
//<td>图书编号</td>
//<td>图书名称</td>
//<td>图书作者</td>
//</tr>
//
//<!--/*@thymesVar id="books" type="templates"*/-->
//<tr th:each="book:${books}">
//<td th:text="${book.id}"></td>
//<td th:text="${book.name}"></td>
//<td th:text="{book.author}"></td>
//</tr>
//</table>
//</body>
//</html>