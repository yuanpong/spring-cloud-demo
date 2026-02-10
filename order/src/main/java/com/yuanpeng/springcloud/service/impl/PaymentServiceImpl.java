package com.yuanpeng.springcloud.service.impl;

import com.yuanpeng.springcloud.common.CommonResult;
import com.yuanpeng.springcloud.service.PaymentService;
import org.apache.tomcat.jni.Lock;
import org.springframework.stereotype.Service;

@Service
//public class PaymentServiceImpl implements PaymentService {
public class PaymentServiceImpl {
    public CommonResult<?> get() {
        return CommonResult.Success("payment");
    }
}
