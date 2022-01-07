package com.ssy.project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LiJun
 * @date 2022-01-06 14:33
 */
@SpringBootApplication
@EnableDiscoveryClient //服务发现注解   用于注册中心能够发现，扫描到改服务   如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(OrderApplication.class);
        springApplication.run(args);
    }


}
