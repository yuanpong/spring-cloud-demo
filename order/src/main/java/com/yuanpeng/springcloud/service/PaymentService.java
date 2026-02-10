package com.yuanpeng.springcloud.service;


import com.yuanpeng.springcloud.common.CommonResult;
import com.yuanpeng.springcloud.service.hystrix.PaymentHystrixService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVER",fallback = PaymentHystrixService.class)
public interface PaymentService {

    @GetMapping("/payment/get")
    CommonResult<?> get();

    @GetMapping("/payment/hystrix")
    CommonResult<?> getHystrix();

    @GetMapping("/payment/hystrixBreak/{id}")
    CommonResult<?> hystrixBreak(@PathVariable("id") int id);
}
