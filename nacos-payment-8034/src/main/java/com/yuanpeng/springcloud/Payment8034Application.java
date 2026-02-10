package com.yuanpeng.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringCloudApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Payment8034Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8034Application.class, args);
        System.out.println("Payment8034Application is start");
    }






}
