package com.yuanpeng.springcloud.blockHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class ConsumerBlockHandler {

    public static String commonBlockHandler(String p1,String p2,BlockException blockException) {

        return "sentinel fall back, commonBlockHandler。";
    }
}
