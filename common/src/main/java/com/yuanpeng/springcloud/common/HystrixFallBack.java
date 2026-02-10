package com.yuanpeng.springcloud.common;

public interface HystrixFallBack {
    public static String PAYMENT_HYSTRIX_FALL_BACK= "payment time out, fallback";
}
