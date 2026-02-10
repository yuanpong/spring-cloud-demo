package com.yuanpeng.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Order8022Application {
    public static void main(String[] args) {
        SpringApplication.run(Order8022Application.class, args);
        System.out.println("Order8022Application is start");
    }


}
