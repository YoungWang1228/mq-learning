package com.youngwang.rabbitmq.oson;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王治杨
 * @since 2020-04-11 21:35
 */
@Configuration
public class TopicOsonReceiver {
    public static final String OSON_TOPIC_QUEUE = "oson-topic-queue";
    public static final String OSON_TOPIC_EXCHANGE = "oson-topic-exchange";
    public static final String OSON_TOPIC_ROUTING_KEY = "oson-topic-routing-key";

    @Autowired
    public AmqpTemplate amqpTemplate;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(OSON_TOPIC_QUEUE),
                    exchange = @Exchange(value = OSON_TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),
                    key = OSON_TOPIC_ROUTING_KEY
            )
    )
    public void receive(String msg) {
        System.out.println("receive topic msg : " + msg);
    }

}
