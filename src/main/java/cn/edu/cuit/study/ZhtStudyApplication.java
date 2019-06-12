package cn.edu.cuit.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @date: 2019/5/15
 * @author: Flemming
 * @description:
 */

@SpringBootApplication
@MapperScan("cn.edu.cuit.study.dao")
public class ZhtStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhtStudyApplication.class);
    }

}
