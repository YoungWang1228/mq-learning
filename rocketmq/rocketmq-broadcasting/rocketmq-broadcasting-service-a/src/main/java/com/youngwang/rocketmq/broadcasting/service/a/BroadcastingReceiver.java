package com.youngwang.rocketmq.broadcasting.service.a;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author 王治杨
 * @since 2020-04-12 21:28
 */
@Component
@RocketMQMessageListener(
        topic = BroadcastingReceiver.BROADCASTING_TOPIC,
        consumerGroup = "${spring.application.name}-" + BroadcastingReceiver.BROADCASTING_TOPIC,
        messageModel = MessageModel.BROADCASTING,
        consumeThreadMax = 1
)
public class BroadcastingReceiver implements RocketMQListener<String> {
    public static final String BROADCASTING_TOPIC = "broadcasting-topic";

    @Override
    public void onMessage(String message) {
        System.out.printf("receive %s msg : %s \n", BROADCASTING_TOPIC, message);
    }
}
