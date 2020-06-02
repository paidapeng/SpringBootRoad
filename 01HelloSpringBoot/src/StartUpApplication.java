import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 *   
 *  @Title: StartUpApplication
 *  @Package PACKAGE_NAME
 *  @Description: 
 *  @author Liush  
 *  @date 2020/5/14
 *  @version V1.0  
 **/
@SpringBootApplication
@ComponentScan(basePackageClasses = EmbeddedDatabaseConnection.class)
public class StartUpApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartUpApplication.class, args);
    }
}
