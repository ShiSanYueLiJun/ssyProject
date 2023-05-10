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
        System.setProperty("nacos.logging.default.config.enabled","false");
        SpringApplication springApplication = new SpringApplication(PointsApplication.class);
        springApplication.run(args);
    }
}
