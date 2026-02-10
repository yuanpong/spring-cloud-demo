package com.yuanpeng.springcloud.common;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level FeignLogger(){
        return Logger.Level.FULL;
    }
}
