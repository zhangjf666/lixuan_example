package com.lixuan.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.lixuan.component.Subscriber;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class RedisConfig {
    /**
     * 自定义 redisTemplate<String, Object>
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类
        // om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        // om.activateDefaultTyping(BasicPolymorphicTypeValidator.builder().build(), ObjectMapper.DefaultTyping.EVERYTHING);
        om.activateDefaultTyping(new LaissezFaireSubTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
        om.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 不转换值为 null 的对象
        // om.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // key 采用 string 的序列化方式
        template.setKeySerializer(new StringRedisSerializer());
        // value 采用 jackson 的序列化方式
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash 的 key 采用 string 的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        // hash 的 value 采用 jackson 的序列化方式
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }

    @Autowired
    private transient List<Subscriber> subscriptorList;

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        //创建一个消息监听对象
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        //将监听对象放入到容器中
        container.setConnectionFactory(connectionFactory);

        if (this.subscriptorList != null && this.subscriptorList.size() > 0) {
            for (Subscriber subscriber : this.subscriptorList) {
                if (subscriber == null || StringUtils.isBlank(subscriber.getTopic())) {
                    continue;
                }
                //一个订阅者对应一个主题通道信息
                container.addMessageListener(subscriber, new PatternTopic(subscriber.getTopic()));
            }
        }
        return container;
    }
}
