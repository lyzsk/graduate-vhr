package cn.sichu.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 * @author sichu
 * @date 2022/05/11
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "cn.sichu.vhr.mapper")
@EnableScheduling
public class VhrApplication {
    public static void main(String[] args) {
        SpringApplication.run(VhrApplication.class, args);
    }
}
