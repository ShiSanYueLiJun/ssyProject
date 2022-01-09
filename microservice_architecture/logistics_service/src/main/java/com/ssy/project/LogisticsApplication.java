package com.ssy.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LiJun
 * @date 2022-01-07 09:31
 */
@SpringBootApplication
public class LogisticsApplication {


    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(LogisticsApplication.class);
        springApplication.run(args);
    }
}
