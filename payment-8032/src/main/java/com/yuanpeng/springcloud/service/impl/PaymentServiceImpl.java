package com.yuanpeng.springcloud.service.impl;

import com.yuanpeng.springcloud.common.CommonResult;
import com.yuanpeng.springcloud.common.Payment;
import com.yuanpeng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
}
