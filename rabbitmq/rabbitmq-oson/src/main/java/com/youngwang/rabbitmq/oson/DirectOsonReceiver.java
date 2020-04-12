package com.youngwang.rabbitmq.oson;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王治杨
 * @since 2020-04-11 21:35
 */
@Configuration
public class DirectOsonReceiver {
    public static final String OSON_DIRECT_QUEUE = "oson-direct-queue";

    @Autowired
    public AmqpTemplate amqpTemplate;

    @RabbitListener(
            queuesToDeclare = @Queue(OSON_DIRECT_QUEUE)
    )
    public void receive(String msg) {
        System.out.println("receive direct msg : " + msg);
    }

}
