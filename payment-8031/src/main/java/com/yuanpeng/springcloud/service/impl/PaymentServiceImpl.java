package com.yuanpeng.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yuanpeng.springcloud.common.CommonResult;
import com.yuanpeng.springcloud.common.Payment;
import com.yuanpeng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.TimeUnit;


@Service
public class PaymentServiceImpl implements PaymentService {
    @Value("${server.port}")
    private String port;

    @Override
    public CommonResult<?> get() {
        return CommonResult.Success("payment, port:" + port);
    }

    @Override
    public CommonResult<?> insert(@RequestBody Payment payment) {
        return CommonResult.Success("payment , content: " + payment.content + ",port: " + port);
    }



    @Override
    @HystrixCommand(fallbackMethod = "getFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")

    })
    public CommonResult<?> getHystrix() {
        try {
            //int s = 10/0;
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CommonResult.Success("payment");
    }
//    @HystrixCommand(fallbackMethod = "hystrixBreak_fallback",commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"), // 请求次数
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "20000"), // 时间窗口期（10秒）
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 失败率达到指定值后熔断
//    })
    @Override
    public CommonResult<?> hystrixBreak(@PathVariable("id")int id) {
        if(id ==1){
            throw new RuntimeException("服务熔断");
        }
        return CommonResult.Success("payment");
    }
    public CommonResult<?> hystrixBreak_fallback(@PathVariable("id")int id) {
        return CommonResult.error("payment break");
    }

    public CommonResult<?> getFallback() {
        return CommonResult.error("payment fall back");
    }
}
