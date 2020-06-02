package com.example.springboot_config.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
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
public class YmlValueDomain {
// 属性不需要写全，可以写某些需要的部分，主要名称需要对应
//    @Value是单个注入
//    value
    @Value("${assign.name}")
    String assignName;
    @Value("${base.name}")
    String baseName;
    @Value("set from @Value")
    String speak;
    @Value("#{27*3}")
    int age;
}
