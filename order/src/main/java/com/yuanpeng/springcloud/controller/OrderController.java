package com.yuanpeng.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yuanpeng.springcloud.common.CommonResult;
import com.yuanpeng.springcloud.common.Payment;
import com.yuanpeng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
//@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    //String paymentUrl_get =  "http://127.0.0.1:8001/payment/get";
    //String paymentUrl_inset =  "http://127.0.0.1:8001/payment/insert";

    String paymentUrl_get =  "http://CLOUD-PAYMENT-SERVER/payment/get";
    String paymentUrl_inset =  "http://CLOUD-PAYMENT-SERVER/payment/insert";

    @Autowired
    private PaymentService paymentService;


    @GetMapping("/get")
    public CommonResult<?> get() {
        return paymentService.get();
    }


    @GetMapping("/getForRest")
    @LoadBalanced
    public CommonResult<?> getForRest() {
        return restTemplate.getForObject(paymentUrl_get, CommonResult.class);

    }

    @PostMapping("/insert")
    public CommonResult<?> insert(@RequestBody Payment payment) {
        return restTemplate.postForObject(paymentUrl_inset, payment, CommonResult.class);

    }

    @GetMapping("/hystrix")
   /* @HystrixCommand(fallbackMethod = "paymentGlobalFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    @HystrixCommand
    public CommonResult<?> getHystrix() {
        return paymentService.getHystrix();
    }

    public CommonResult<?> paymentGlobalFallback() {
        return CommonResult.error("payment time out ,order fall back");
    }


    @GetMapping("/hystrixBreak/{id}")
    public CommonResult<?> hystrixBreak(@PathVariable("id") int id) {
        return paymentService.hystrixBreak(id);
    }

}
