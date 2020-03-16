package org.sang.utli;

import org.springframework.context.annotation.Configuration;


//虽然启动类含有@Configuration注解，但开发者可以创建一个新的类专门用来配置Bean
/**
 * 项目启动类中的@ComponentScan注解，除了扫描Service、@Repository、@Component
 * 、@Controller、@RestController等之外，也会扫描@Configuration
 */
@Configuration
public class MyCofig {
}
