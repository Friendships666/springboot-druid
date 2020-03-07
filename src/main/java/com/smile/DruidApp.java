package com.smile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DruidApp {

    public static void main(String[] args) {
        SpringApplication.run(DruidApp.class, args);
        System.out.println("***********项目已经启动*************");
    }

}
