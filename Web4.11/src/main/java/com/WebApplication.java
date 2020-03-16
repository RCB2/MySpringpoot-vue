package com;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 * 项目启动类中的@ComponentScan注解，除了扫描Service、@Repository、@Component
 * 、@Controller、@RestController等之外，也会扫描@Configuration
 */

//@SpringBootApplication
//@EnableAutoConfiguration//表示开启自动化配置，项目中添加了spring-boot-starter-web在开启之后自动进行Spring和SpringMVC的配置
//@ComponentScan//扫描的类，默认是当前类所在的包下面，启动类放在根包下面
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
