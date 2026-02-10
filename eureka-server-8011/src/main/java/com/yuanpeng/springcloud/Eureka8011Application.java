package com.yuanpeng.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class Eureka8011Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka8011Application.class, args);
        System.out.println("Eureka Server http://localhost:8011");
        System.out.println("Eureka Server http://eurekaserver8011.com:8011");
    }


}
