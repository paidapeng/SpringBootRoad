package controller;

import domin.ExcelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UserTest;

import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @Title: HelloController
 *  @Package controller
 *  @Description: 
 *  @author Liush  
 *  @date 2020/5/14
 *  @version V1.0  
 **/
@RestController
public class HelloController {

    @Autowired
    UserTest test;

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot,Index!";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
            List<String> fileHandName = new ArrayList<>();
            fileHandName.add("记录号");
            fileHandName.add("共享iFC编号");
            fileHandName.add("共享iFC名称");
            fileHandName.add("优先级");
            fileHandName.add("业务类型");
            fileHandName.add("会话默认处理方式");
            fileHandName.add("包含注册请求");
            fileHandName.add("包含注册响应");
            fileHandName.add("CNF条件类型");
            fileHandName.add("业务信息");
            fileHandName.add("AS 主机名");
//        test.readFileByLines("F:/linshiwenjian.txt");
            List<ExcelModel> fileList =test.readFileByLines("F:/linshiwenjian.txt");
            try {
                test.writeExcel1(fileList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return "Spring Boot Test Demo!";
    }
}
