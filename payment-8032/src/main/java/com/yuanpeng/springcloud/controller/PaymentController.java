package com.yuanpeng.springcloud.controller;

import com.yuanpeng.springcloud.common.CommonResult;
import com.yuanpeng.springcloud.common.Payment;
import com.yuanpeng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
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
    @PostMapping("/insert")
    public CommonResult<?> insert(@RequestBody Payment payment){
        return paymentService.insert(payment);

    }

}
