package com.yuanpeng.springcloud.producer;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
public class ProducerDemo{
    @Resource
    private RocketMQTemplate rocketMQTemplate;


    @Value("${demo.rocketmq.topic}")
    private String springTopic;


    @RequestMapping("/health")
    public String  ok()  {
        return "ok";
    }


    @RequestMapping("/sync")
    public SendResult run()  {
        SendResult sendResult = rocketMQTemplate.syncSend(springTopic, "Hello, World!");
        System.out.printf("syncSend1 to topic %s sendResult=%s %n", springTopic, sendResult);
        return sendResult;
    }
}
