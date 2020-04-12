package com.youngwang.rocketmq.mson.service.a;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author 王治杨
 * @since 2020-04-12 21:28
 */
@Component
@RocketMQMessageListener(
        topic = MsonReceiver.MSON_TOPIC,
        consumerGroup = "${spring.application.name}-" + MsonReceiver.MSON_TOPIC,
        consumeThreadMax = 1
)
public class MsonReceiver implements RocketMQListener<String> {
    public static final String MSON_TOPIC = "mson-topic";

    @Override
    public void onMessage(String message) {
        System.out.printf("receive %s msg : %s \n", MSON_TOPIC, message);
    }
}
