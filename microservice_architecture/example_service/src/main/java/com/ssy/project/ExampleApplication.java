package com.ssy.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LiJun
 * @date 2022-01-06 17:48
 */
@SpringBootApplication
public class ExampleApplication {


    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ExampleApplication.class);
        springApplication.run(args);
    }

}



