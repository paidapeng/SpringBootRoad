package com.example.springboot_config.controller;

import com.example.springboot_config.service.ReadConfigService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ReadConfigController {
    @Autowired
    ReadConfigService readConfigService;
// http://localhost:8081/readYmlConfig
    @RequestMapping("/readYmlConfig")
    public String readYmlConfig() {
        return readConfigService.readYmlConfigDomian();
    }
//    http://localhost:8081/readYmlValueConfig
    @RequestMapping("/readYmlValueConfig")
    public String readYmlValueConfig() {
        return readConfigService.readYmlValueDomian();
    }
}
