package com.example.springboot_config.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *   
 *  @Title: HelloController
 *  @Package com.example.springboot_config.controller
 *  @Description: 测试springboot启动情况
 *  @author Liush  
 *  @date 2020/6/2
 *  @version V1.0  
 **/
@RestController
public class HelloController {
//    http://localhost:8081/hello
    @RequestMapping( params = "hellos")
    public String hellosSpringboot(){
        return "hellos";
    }

    @RequestMapping("/hello")
    public String helloSpringboot(){
        return "hello";
    }
}
