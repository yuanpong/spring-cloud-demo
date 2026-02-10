package com.yuanpeng.springcloud.common;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RibbonRule {

    @Bean
    public IRule getRibbonRule (){
        return new RandomRule();
    }
}
