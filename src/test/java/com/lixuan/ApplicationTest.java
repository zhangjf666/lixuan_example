package com.lixuan;

import com.lixuan.constant.RedisTopicEnums;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
public class ApplicationTest {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void redisPulishTest(){
        redisTemplate.convertAndSend(RedisTopicEnums.TOPIC_PVMS.getTopic(), "{\n" +
                "\"MsgType\": \"StopModeling\",\n" +
                "\"FunctionType\": \"Regist\",    // \"Regist\": 注册  \"Measure\": 测量\n" +
                "\"RegistModelPath\": \"/data/DTC/Truck/A010101_20230628_130000_000.pcd\", \n" +
                "\"TimeStamp\": \"20230628_130000_000\",\n" +
                "\"TruckID\": \"A010101\"\n" +
                "}\n");
    }
}
