package com.youngwang.redismq.broadcasting.pubsub.service.b;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author 王治杨
 * @since 2020-04-07 21:19
 */
@Configuration
public class BroadcastingPubsubReceiver {

    public static final String BROADCASTING_PUBSUB_MQ_KEY = "BROADCASTING_PUBSUB_MQ_KEY";

    @Bean
    public MessageListener messageListener(RedisTemplate<String, String> redisTemplate,
                                           RedisMessageListenerContainer container) {
        MessageListener listener = (message, pattern) -> {
            String value = (String) redisTemplate.getValueSerializer().deserialize(message.getBody());
            System.out.println(value);
        };

        container.addMessageListener(listener, new ChannelTopic(BROADCASTING_PUBSUB_MQ_KEY));
        return listener;
    }

    @Bean
    public RedisMessageListenerContainer messageListenerContainer(RedisConnectionFactory factory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        return container;
    }

}
