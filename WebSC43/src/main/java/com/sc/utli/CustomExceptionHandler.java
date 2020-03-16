package com.sc.utli;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 * @ControllerAdvice为常见使用场景是全局异常处理
 * 如果用户上传的文件超出限制大小，就会抛出异常
 * @ControllerAdvice结合ExceptionHandler定义全局异常捕获机制
 */
@ControllerAdvice
public class CustomExceptionHandler {
////    @ExceptionHandler(Exception.class)//处理所有异常，下面方法括号中e的定义类型改为Exception即可处理所有不同种类异常
//    @ExceptionHandler(MaxUploadSizeExceededException.class)//
//    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse resp)throws IOException {
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter out = resp.getWriter();
//        out.write("上传文件大小超出限制,请到配置文件properties设置上传大小限制");
//        out.flush();
//        out.close();
//    }
    /**
     * 只需在系统中定义CustomExceptionHandler类，添加ControllerAdvice注解
     * 系统启动，该类会被扫描到Spring容器中
     * 然后定义uploadException方法，在上面添加注解ExceptionHandler注解，
     * 其中括号定义的...类表明该方法用来处理MaxUploadSizeExceededException
     * 类型的异常，
     * 若想要处理所有的异常，只需要将MaxUploadSizeExceededException改为Exception
     *
     *方法的参数可以有异常实例、HttpServletResponse以及HttpServletRequest、Model
     * 返回值可以是JSON、一个ModelAndView、一个逻辑视图名
     *
     *
     * 如果返回参数为一个ModelAndView，假设使用的页面模板为Thymeleaf（注意添加Thymeleaf相关依赖）
     * 异常处理方法如下：
     * */
//    返回值为ModelAndView类型，该方法与上面方法几乎一致,该方法与上面方法可以2选1，但下面这一方发用法用到Thymeleaf模板，因为返回值为ModelAndView类型
    @ExceptionHandler(Exception.class)//
    public ModelAndView uploadException2(Exception e, HttpServletResponse resp)throws IOException {
        ModelAndView mv = new ModelAndView();
        /**
         * msg用于前台接收信息时用到，他后面就是要接收的数据
         * error为要跳转到的页面
         */
        mv.addObject("msg","上传文件大小超出限制，请到配置文件调整上传文件的大小");
        mv.setViewName("error");
        return mv;
    }
    /**
     * 处理异常时，可以根据实际情况返回不同页面，但这种异常
     * 处理方式一般用于处理应用级别的异常，有些容器级别的错误就处理不了，
     * 如Filter中抛出异常，使用@ControllerAdvice定义的全局异常除了机制
     * 就无法处理，因此spring boot处理异常还有另外一种方式，4.5节将会讲到
     */

//    /**
//     *4.4.2 添加全局数据
//     *
//     * 源码是另外创建一个类GlobalConfig,将下面的方法写到此类中
//     *
//     *返回值为Model类型，
//     * @ControllerAdvice是一个全局数据处理组件，为此在他中配置全局数据，
//     * 使用@ModelAttribute注解进行配置
//     */
//     @ModelAttribute(value = "info")
//     public Map<String,String> ueseInfo(){
//       HashMap<String,String> map = new HashMap<>();
//       map.put("username","阮春彪");
//       map.put("gender","性别男");
//       return map;
//
//     }

}
