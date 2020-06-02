import java.util.ArrayList;
import java.util.List;

/**
 *   
 *  @Title: main
 *  @Package PACKAGE_NAME
 *  @Description: 
 *  @author Liush  
 *  @date 2020/5/14
 *  @version V1.0  
 **/
public class main {
    public static void main(String[] args) {
        UserTest test = new UserTest();
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
//        List<ExcelModelHW> fileListHW =test.readFileByLinesHW("F:/huawei.txt");
        List<ExcelModelZTH> fileListZTH =test.readFileByLinesZTH("F:/zhongxing.txt");
        String path = "F:/广州大区数据.xlsx";
        try {
//            test.writeExcel1HW(fileListHW,path);
            test.writeExcel1ZTH(fileListZTH,path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
