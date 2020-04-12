package com.youngwang.rabbitmq.broadcasting.service.b;

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
public class TopicBroadcastingReceiver {
    public static final String BROADCASTING_EXCHANGE = "broadcasting-exchange";
    public static final String BROADCASTING_ROUTING_KEY = "broadcasting-routing-key";

    @Autowired
    public AmqpTemplate amqpTemplate;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = BROADCASTING_EXCHANGE, type = ExchangeTypes.TOPIC),
                    key = BROADCASTING_ROUTING_KEY
            )
    )
    public void receive(String msg) {
        System.out.println("receive broadcasting msg : " + msg);
    }

}
