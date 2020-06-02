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
public class ExcelModelZTH extends BaseRowModel {
    @ExcelProperty(value = "记录号", index = 0)
    private String value1;

    @ExcelProperty(value = "共享iFC编号", index = 1)
    private String value2;

    @ExcelProperty(value = "共享iFC名称", index = 2)
    private String value3;

    @ExcelProperty(value = "优先级", index = 3)
    private String value4;

    @ExcelProperty(value = "业务类型", index = 4)
    private String value5;

    @ExcelProperty(value = "会话默认处理方式", index = 5)
    private String value6;

    @ExcelProperty(value = "包含注册请求", index = 6)
    private String value7;

    @ExcelProperty(value = "包含注册响应", index = 7)
    private String value8;

    @ExcelProperty(value = "CNF条件类型", index = 8)
    private String value9;

    @ExcelProperty(value = "业务信息", index = 9)
    private String value10;

    @ExcelProperty(value = "AS 主机名", index = 10)
    private String value11;

    @ExcelProperty(value = "SPT 编号1", index = 11)
    private String value12;

    @ExcelProperty(value = "SPT 编号2", index = 12)
    private String value13;

    @ExcelProperty(value = "SPT 编号3", index = 13)
    private String value14;


}
