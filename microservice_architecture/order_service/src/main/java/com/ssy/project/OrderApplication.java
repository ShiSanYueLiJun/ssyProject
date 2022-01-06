package com.ssy.project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LiJun
 * @date 2022-01-06 14:33
 */
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(OrderApplication.class);
        springApplication.run(args);
    }


}
