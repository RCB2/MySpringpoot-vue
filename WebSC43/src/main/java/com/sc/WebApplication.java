package com.sc;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new
                SpringApplicationBuilder(WebApplication.class);
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
