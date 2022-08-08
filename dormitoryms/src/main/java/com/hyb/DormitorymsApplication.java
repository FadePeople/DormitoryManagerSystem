package com.hyb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@MapperScan("com.hyb.mapper")
public class DormitorymsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DormitorymsApplication.class, args);
    }

}
