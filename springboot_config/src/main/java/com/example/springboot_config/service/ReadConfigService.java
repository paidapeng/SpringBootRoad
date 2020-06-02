package com.example.springboot_config.service;

import com.example.springboot_config.config.YmlConfigDomain;
import com.example.springboot_config.config.YmlValueDomain;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *   
 *  @Title: ReadConfigService
 *  @Package com.example.springboot_config.service
 *  @Description: 读取配置文件
 *  @author Liush  
 *  @date 2020/6/2
 *  @version V1.0  
 **/
@Service
@Log4j
public class ReadConfigService {
    @Autowired
    YmlConfigDomain ymlConfigDomain;

    @Autowired
    YmlValueDomain ymlValueDomain;

    public String readYmlConfigDomian(){
        return ymlConfigDomain.toString();
    }

    public String readYmlValueDomian(){
        return ymlValueDomain.toString();
    }
}
