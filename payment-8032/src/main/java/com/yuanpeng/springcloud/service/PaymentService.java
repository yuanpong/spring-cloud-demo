package com.yuanpeng.springcloud.service;


import com.yuanpeng.springcloud.common.CommonResult;
import com.yuanpeng.springcloud.common.Payment;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentService {
    CommonResult<?> get();

    CommonResult<?> insert(@RequestBody Payment payment);
}
