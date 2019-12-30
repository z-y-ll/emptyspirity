package cn.emptyspirit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zyll
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@MapperScan("cn.emptyspirit.mapper")
@ComponentScan("cn.emptyspirit.global")
public class EmptyspiritApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmptyspiritApplication.class, args);
    }
}
