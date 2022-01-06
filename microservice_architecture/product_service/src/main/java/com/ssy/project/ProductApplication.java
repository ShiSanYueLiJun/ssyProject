package com.ssy.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LiJun
 * @date 2022-01-06 17:01
 */
@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ProductApplication.class);
        springApplication.run(args);
    }


}
