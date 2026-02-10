package com.yuanpeng.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;



@SpringCloudApplication
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
        System.out.println("ProducerApplication is start");
    }






}
