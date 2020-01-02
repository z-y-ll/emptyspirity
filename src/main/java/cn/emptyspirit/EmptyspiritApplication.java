package cn.emptyspirit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author zyll
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.emptyspirit.mapper")
public class EmptyspiritApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmptyspiritApplication.class, args);
    }
}
