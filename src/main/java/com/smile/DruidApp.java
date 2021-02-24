package com.smile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.smile.mapper")
public class DruidApp {

    public static void main(String[] args) {
        SpringApplication.run(DruidApp.class, args);
        System.out.println("***********项目已经启动*************");
        System.out.println("***********github update*************");
		System.out.println("***********update to github*************");
    }

}
