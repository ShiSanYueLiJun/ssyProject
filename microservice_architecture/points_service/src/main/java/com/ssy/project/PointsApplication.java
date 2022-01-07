package com.ssy.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LiJun
 * @date 2022-01-07 09:31
 */
@SpringBootApplication
public class PointsApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(PointsApplication.class);
        springApplication.run(args);
    }
}
