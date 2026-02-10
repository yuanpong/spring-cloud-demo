package com.yuanpeng.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yuanpeng.springcloud.blockHandler.ConsumerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @GetMapping("/ok")
    public String health() {
        return "ok";
    }

    @GetMapping("/limit/x")
    public String limitX() {
        return "limitX";
    }
    @GetMapping("/limit/y")
    public String limitY() {
        return "limitY";
    }

    @GetMapping("/break")
    public String sentinelBreak() {
        int x = 10/0;
        return "break";
    }
    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey", blockHandlerClass = ConsumerBlockHandler.class, blockHandler = "hotKeyBlockHandler")
    public String hotKey(@RequestParam(value = "p1",required = false)String p1,
                         @RequestParam(value = "p2",required = false)String p2) {
        return "hotKey";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String sentinelHotKey(@RequestParam(value = "p1",required = false)String p1,
                                 @RequestParam(value = "p2",required = false)String p2) {
        return "testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException blockException) {

        return "sentinel fall back";
    }

}
