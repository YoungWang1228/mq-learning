package com.youngwang.rabbitmq.mson.service.a;

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
public class TopicMsonReceiver {
    public static final String MSON_QUEUE = "mson-queue";
    public static final String MSON_EXCHANGE = "mson-exchange";
    public static final String MSON_ROUTING_KEY = "mson-routing-key";

    @Autowired
    public AmqpTemplate amqpTemplate;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(MSON_QUEUE + "-${spring.application.name}"),
                    exchange = @Exchange(value = MSON_EXCHANGE, type = ExchangeTypes.TOPIC),
                    key = MSON_ROUTING_KEY
            )
    )
    public void receive(String msg) {
        System.out.println("receive topic msg : " + msg);
    }

}
