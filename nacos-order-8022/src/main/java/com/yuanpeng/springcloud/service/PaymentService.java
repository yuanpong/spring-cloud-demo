package com.yuanpeng.springcloud.service;


import com.yuanpeng.springcloud.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "cloud-nacos-payment-provider")
public interface PaymentService {

    @GetMapping("/payment/get")
    CommonResult<?> get();

    @GetMapping("/payment/hotKey")
    CommonResult<?> hotKey();
}
