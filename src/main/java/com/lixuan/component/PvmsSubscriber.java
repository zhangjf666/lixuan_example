package com.lixuan.component;

import com.lixuan.constant.RedisTopicEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PvmsSubscriber implements Subscriber {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public String getTopic() {
        return RedisTopicEnums.TOPIC_PVMS.getTopic();
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String content = (String) redisTemplate.getValueSerializer().deserialize(message.getBody());
        log.info("收到订阅消息,内容:{}", content);
    }
}
