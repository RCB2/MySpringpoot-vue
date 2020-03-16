package com;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 项目启动类中的@ComponentScan注解，除了扫描Service、@Repository、@Component
 * 、@Controller、@RestController等之外，也会扫描@Configuration
 */

@SpringBootApplication
//@EnableAutoConfiguration//表示开启自动化配置，项目中添加了spring-boot-starter-web在开启之后自动进行Spring和SpringMVC的配置
//@ComponentScan//扫描的类，默认是当前类所在的包下面，启动类放在根包下面
public class TestApplication {
    public static void main(String[] args) {
//            SpringApplication.run(TestApplication.class,args} ;//这一行启动整体项目
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
    /**
     * Spring Boot 提供了大量的自动化配置类，例如上文提到过的 ErrorMvcAutoConfiguration
     * ThymeleafAutoConfiguration FreeMarkerAutoConfiguration MultipartAutoConfiguration 等，这些自
     * 动化配置可以减少相应操作的配置，达到开箱即用的效果。在 Spring Boot 的入口类上有
     * @Spring BootApplication 注解。该注解是 个组合注解， 由＠ pring BootConfiguration
     * @EnableAutoConfiguration 以及＠ComponentScan 组成，其中＠EnableAutoConfiguration 注解开启自
     * 动化配置，相关的自动化配置类就会被使 如果开发者不想使用某个 自动化配置，按如下方式除
     * 去相关配置即可：
     *
     * 下面的注解放到启动类上面
     * @EnableAutoConfiguration (exclude = { ErrorMvcAutoConfiguration.class})
     *
     */