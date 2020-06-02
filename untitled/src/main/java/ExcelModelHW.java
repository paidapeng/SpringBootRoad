import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *   
 *  @Title: excel
 *  @Package domin
 *  @Description: excel的文件实体类
 *  @author Liush  
 *  @date 2020/5/14
 *  @version V1.0  
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExcelModelHW extends BaseRowModel {
    @ExcelProperty(value = "共享iFC模板标识", index = 0)
    private String value1;

    @ExcelProperty(value = "共享iFC名称", index = 1)
    private String value2;

    @ExcelProperty(value = "优先级", index = 2)
    private String value3;

    @ExcelProperty(value = "业务相关性", index = 3)
    private String value4;

    @ExcelProperty(value = "AS服务器地址", index = 4)
    private String value5;

    @ExcelProperty(value = "默认处理方式", index = 5)
    private String value6;

    @ExcelProperty(value = "业务信息", index = 6)
    private String value7;

    @ExcelProperty(value = "携带第一方注册请求", index = 7)
    private String value8;

    @ExcelProperty(value = "携带第一方注册响应", index = 8)
    private String value9;

    @ExcelProperty(value = "触发点", index = 9)
    private String value10;

    @ExcelProperty(value = "备用1", index = 9)
    private String value11;

    @ExcelProperty(value = "备用2", index = 9)
    private String value12;

    @ExcelProperty(value = "备用3", index = 9)
    private String value13;


}
