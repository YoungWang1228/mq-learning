package com.youngwang.rocketmq.oson;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author 王治杨
 * @since 2020-04-12 11:10
 */
@Component
@RocketMQMessageListener(
        topic = OsonTopicAReceiver.OSON_TOPIC_A,
        consumerGroup = "${spring.application.name}-" + OsonTopicAReceiver.OSON_TOPIC_A,
        consumeThreadMax = 1
)
public class OsonTopicAReceiver implements RocketMQListener<String> {
    public static final String OSON_TOPIC_A = "oson-topic-a";

    @Override
    public void onMessage(String message) {
        System.out.printf("receive %s msg : %s \n", OSON_TOPIC_A, message);
    }
}
