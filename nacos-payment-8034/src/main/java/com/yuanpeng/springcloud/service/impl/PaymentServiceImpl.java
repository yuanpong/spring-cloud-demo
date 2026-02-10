package com.yuanpeng.springcloud.service.impl;


import com.yuanpeng.springcloud.common.CommonResult;

import com.yuanpeng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class PaymentServiceImpl implements PaymentService {
    @Value("${server.port}")
    private String port;

    @Override
    public CommonResult<?> get() {
        return CommonResult.Success("nacos payment, port:" + port);
    }

    @Override
    public CommonResult<?> hotKey(String p1,String p2) {
        return CommonResult.Success("nacos payment hotKey, port:" + port);
    }

}
