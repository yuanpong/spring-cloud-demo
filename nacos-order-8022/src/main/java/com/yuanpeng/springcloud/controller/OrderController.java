package com.yuanpeng.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yuanpeng.springcloud.blockHandler.ConsumerBlockHandler;
import com.yuanpeng.springcloud.common.CommonResult;
import com.yuanpeng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {
    @Autowired
    private PaymentService paymentService;

    @Value("${config}")
    public String config;

    @RequestMapping("/config")
    public String config(){
        return config;
    }

    @GetMapping("/get")
    public CommonResult<?> get() {
        return paymentService.get();
    }

    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey", fallback = "hotKeyFallback",blockHandlerClass = ConsumerBlockHandler.class, blockHandler = "commonBlockHandler")
    public CommonResult<?> hotKey(@RequestParam(value = "p1",required = false)String p1,
                         @RequestParam(value = "p2",required = false)String p2) {
        return paymentService.hotKey();
    }

    public CommonResult<?> hotKeyFallback(String p1, String p2) {
        return CommonResult.error("hotKey fall back");
    }


}
