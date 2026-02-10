package com.yuanpeng.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
//@MapperScan("com.yuanpeng.springcloud.dao")
public class Payment8032Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8032Application.class, args);
        System.out.println("Payment8032 Application is start");
    }

}
