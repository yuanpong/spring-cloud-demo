package com.yuanpeng.springcloud.service.hystrix;

import com.yuanpeng.springcloud.common.HystrixFallBack;
import com.yuanpeng.springcloud.common.CommonResult;
import com.yuanpeng.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixService implements PaymentService {
    @Override
    public CommonResult<?> get() {
        return CommonResult.error(HystrixFallBack.PAYMENT_HYSTRIX_FALL_BACK);
    }

    @Override
    public CommonResult<?> getHystrix() {
        return CommonResult.error(HystrixFallBack.PAYMENT_HYSTRIX_FALL_BACK);
    }

    @Override
    public CommonResult<?> hystrixBreak(int id) {
        return CommonResult.error(HystrixFallBack.PAYMENT_HYSTRIX_FALL_BACK);
    }


}
