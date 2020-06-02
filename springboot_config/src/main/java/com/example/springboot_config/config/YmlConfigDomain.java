package com.example.springboot_config.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 *   
 *  @Title: ReadConfig
 *  @Package com.example.springboot_config.config
 *  @Description: 读取config中的内容
 *  @author Liush  
 *  @date 2020/6/2
 *  @version V1.0  
 **/
@Data
@Component
//绑定固定的某个对象的属性,这个注解需要在组件Bean中才能生效
@ConfigurationProperties(prefix = "assign")
//ConfigurationProperties 是批量匹配导入
//    支持松散绑定
//    如大写字母为 firstName
//    可以表示为first_name 或 first-name

public class YmlConfigDomain {
// 属性不需要写全，可以写某些需要的部分，主要名称需要对应
    String name;
    String speak;
    int age;
    String idea;
    Map<String,Object> friends;
    List<String> pets;
    String say;
}
