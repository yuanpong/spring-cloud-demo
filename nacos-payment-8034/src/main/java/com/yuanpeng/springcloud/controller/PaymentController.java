package com.yuanpeng.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yuanpeng.springcloud.blockHandler.ConsumerBlockHandler;
import com.yuanpeng.springcloud.common.CommonResult;
import com.yuanpeng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RefreshScope
public class PaymentController {

    @Autowired
    public PaymentService paymentService;

    @GetMapping("/health")
    public String health(){
        return "ok";

    }
    @GetMapping("/get")
    public CommonResult<?> get(){
        return paymentService.get();

    }

    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey", blockHandlerClass = ConsumerBlockHandler.class, blockHandler = "commonBlockHandler")
    public CommonResult<?> hotKey(@RequestParam(value = "p1",required = false)String p1,
                                  @RequestParam(value = "p2",required = false)String p2) {
        return paymentService.hotKey(p1,p2);
    }

}
