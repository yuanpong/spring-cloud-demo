package com.yuanpeng.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringCloudApplication
@EnableEurekaClient
//@MapperScan("com.yuanpeng.springcloud.dao")
public class Payment8031Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8031Application.class, args);
        System.out.println("Payment8031 Application is start");
    }






}
