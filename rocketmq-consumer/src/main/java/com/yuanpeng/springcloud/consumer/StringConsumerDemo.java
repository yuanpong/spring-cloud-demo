package com.yuanpeng.springcloud.consumer;
import com.google.common.collect.Maps;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
@RocketMQMessageListener(topic = "${demo.rocketmq.topic}", consumerGroup = "string_consumer", selectorExpression = "${demo.rocketmq.tag}", tlsEnable = "${demo.rocketmq.tlsEnable}")
public class StringConsumerDemo implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.printf("------- StringConsumer received: %s \n", message);
    }


    public static void main(String[] args) {

        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("1",1);
        objectObjectHashMap.put("2",null);
        objectObjectHashMap.put("3",null);
        System.out.println(objectObjectHashMap.entrySet());
    }
}
