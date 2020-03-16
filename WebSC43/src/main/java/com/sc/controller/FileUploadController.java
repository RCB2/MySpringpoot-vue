package com.sc.controller;

import jdk.nashorn.internal.ir.WhileNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class FileUploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    /**
     * 4.2
     * 多文件上传
     * @param uploadFile
     * @param req
     * @return
     */
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest req) {

        /*
         *到if完结束
         *20到30行，表示上传文件的保存路径为项目运行目录下的uploadFile文件夹
         *并在文件夹中通过日期对所上传的文件归类保存。
         */
        String realPath = req.getSession().getServletContext()
                .getRealPath("/uploadFile/");//文件上传将要保存的路径（文件夹）
        String format = sdf.format(new Date());//上传时间
//        File folder = new File(realPath+format);//文件上传将要保存的文件夹
        File folder = new File("D://home//"+format);//设置到D盘路径

        System.out.println("folder数据："+folder+"数据realpath:"+realPath+"数据format:"+format);
        if (!folder.isDirectory()) {//判断文件是否为空
            folder.mkdirs();//
        }
        /**
         * 下面三行代码，是给要上传的文件重新命名，避免文件重名
         */
        String oldName = uploadFile.getOriginalFilename();//取得上传文件的名称
        System.out.println("数据："+oldName+UUID.randomUUID().toString()+"===="+oldName.substring(oldName.lastIndexOf("."),oldName.length()));
        String newName = UUID.randomUUID().toString()+//随即生成的文件名称
                oldName.substring(oldName.lastIndexOf("."),oldName.length());//去掉.前缀，获取.后缀，如这里得到.jgp
                        try{
                            uploadFile.transferTo(new File(folder,newName));//该行代码为保存操作，分号改为加号也可以
                            /**
                             * 下面代码作用，生成上传文件的访问路径，并将访问路径返回
                             * req.getScheme()值为http
                             * req.getServerName()值为localhost8080，也就是文件要上传的服务器地址
                             * format为时间
                             * newName
                             *路径可以改到本机电脑上
                             */
                            String filepath = req.getScheme()+"://"+req.getServerName()+
                                    req.getServerPort()+"/uploadFile/"+format+newName;
                            return filepath;
                        }catch (IOException e){
                            e.printStackTrace();
                        }
    return "上传失败";
    }
    /**
     * 浏览器输入....8080/upload.html，单击文件上传，上传成功后，会返回文件访问路径
     * 用这个路径就能看到刚刚上传的图片了·
     */

    /**
     * 4.2
     * 多文件上传
     * @param req
     * @return
     */
    @PostMapping("/uploads")
    public String upload2(MultipartFile[] uploadFiles, HttpServletRequest req) {

        //遍历uploadFiles数组分别储存，页面传来的数据
//        与单文件上传几乎一样，只多出一个遍历

        return "上传失败";
    }

    /**
     * 4.4.2
     *
     * 在全局配置中添加userInfo方法，返回一个map。该方法有注解@ModelAttribute，
     * 其中的value属性表示这条返回数据的key,而方法的返回值是返回数据的value值
     *
     * 此时在任意请求的controller中，通过方法参数中的Model
     * 都可以获取info的数据
     * @return
     *
     */
    @GetMapping("/hello")
//  该类用到了@RestController因此不需要用 注解@ResponseBody
    public String hello(Model model){//可以无返回值
        Map<String,Object> map = model.asMap();//获取到全局数据key="info",value="map",map为方法userInfo()返回值传来的
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            Object value = map.get(key);
            System.out.println(key+">>>>>"+value);
        }
        /**
         * a.注解方法中形参为model,modelmap,map一个或几个时，他们指向的引用对象相同即他们的值相同。
         *
         * b.当使用@ModelAttribute注解请求参数时，springmvc自动将该参数放入model,modelmap,map中。
         */
        return String.valueOf(map);
    }
}
