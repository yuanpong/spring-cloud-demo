package com.yuanpeng.springcloud.snowFlake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SnowflakeHutool {

    private long workId = 0;
    private long datacenterId = 0;
    private Snowflake snowflake = IdUtil.createSnowflake(workId,datacenterId);


    @PostConstruct
    public void init(){
        try {
             workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr()); //机器号
        } catch (Exception e) {
            e.printStackTrace();
             workId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized long snowflakeId(){
        Snowflake snowflake = IdUtil.createSnowflake(workId, datacenterId);
        return snowflake.nextId();
    }

    public static void main(String[] args) {

        System.out.println(new SnowflakeHutool().snowflakeId());
    }
}
