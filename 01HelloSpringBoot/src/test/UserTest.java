import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import domin.ExcelModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *   
 *  @Title: Test
 *  @Package PACKAGE_NAME
 *  @Description: 用于工作临时类
 *  @author Liush  
 *  @date 2020/5/14
 *  @version V1.0  
 **/
public class Test {
    @Test
    public static void main(String[] args) {
        Test test = new Test();
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
        test.readFileByLines("F:/linshiwenjian.txt");
        List<ExcelModel> fileList =test.readFileByLines("F:/linshiwenjian.txt");
        try {
            writeExcel1(fileList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeExcel1(List<ExcelModel> list) throws Exception {
        ExcelModel excelModel = new ExcelModel();
        // 文件输出位置
        OutputStream out = new FileOutputStream("/Users/a123123/Work/tmp_files/test.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        // 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
        Sheet sheet1 = new Sheet(1, 0,excelModel.getClass());

        // 第一个 sheet 名称
        sheet1.setSheetName("第一个sheet");

        // 写数据到 Writer 上下文中
        // 入参1: 创建要写入的模型数据
        // 入参2: 要写入的目标 sheet
        writer.write(list, sheet1);

        // 将上下文中的最终 outputStream 写入到指定文件中
        writer.finish();

        // 关闭流
        out.close();
    }

    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     *
     * @param fileName 文件的名
     */
    public void readFileByBytes(String fileName) {
        File file = new File(fileName);
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1) {
                System.out.write(tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(fileName);
//            ReadFromFile.showAvailableBytes(in);
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
                System.out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     *
     * @param fileName 文件名
     */
    public void readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，rn这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉r，或者屏蔽n。否则，将会多出很多空行。
                if (((char) tempchar) != 'r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉r不显示
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != 'r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == 'r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     *
     * @param fileName 文件名
     */
    public void readFileByLines(String fileName,List<String> handNane) {
        List<ExcelModel> list = new ArrayList<>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                ExcelModel.ExcelModelBuilder excelModel = ExcelModel.builder();
                String [] fileLine = tempString.split("\t");
                if (file.length()==11){
                    for (int i=1;i<=11;i++){
                        excelModel.
                    }
                }
                // 显示行号  4294967295
                System.out.println("line " + line + ": " + tempString);

                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 随机读取文件内容
     *
     * @param fileName 文件名
     */
    public void readFileByRandomAccess(String fileName) {
        RandomAccessFile randomFile = null;
        try {
            System.out.println("随机读取一段文件内容：");
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            // 将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 显示输入流中还剩的字节数
     *
     * @param in
     */
    private void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 在指定目录生成文件
     *
     * @param path     生成路径
     * @param fileName 生成文件名
     * @param head     标题头
     * @param fields   列对应的键值
     * @param list     数据集合
     * @throws Exception
     */
    private void writeCSV(String path, String fileName, String[] head, String[] fields, List<Map<String, Object>> list) throws Exception {
        String separator = ","; //分隔符
        String marks = "\"";    //单引号
        String file = path + fileName;
        BufferedWriter writer = null;
        try {
            File csvFile = new File(file);
            if (csvFile.exists()) {
                csvFile.delete();
            }
            csvFile.createNewFile();

            final BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"), 1024);
            writer = csvWriter;
            // 写入文件头部
            for (int j = 0; j < head.length; j++) {
                StringBuffer sb = new StringBuffer();
                sb.append(marks).append(head[j]).append(marks);
                if (j < head.length - 1) {
                    sb.append(separator);
                }
                csvWriter.write(sb.toString());
            }
            csvWriter.newLine();
            for (Map<String, Object> map : list) {
                for (int j = 0; j < fields.length; j++) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(marks).append(map.get(fields[j])).append(marks);
                    if (j < fields.length - 1) {
                        sb.append(separator);
                    }
                    csvWriter.write(sb.toString());
                }
                csvWriter.newLine();
            }
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
