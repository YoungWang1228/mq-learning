package test.com.youngwang.rabbitmq.broadcasting;

import com.youngwang.rabbitmq.broadcasting.service.a.TopicBroadcastingReceiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王治杨
 * @since 2020-04-11 21:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@SpringBootApplication
public class BroadcastingSender {

    @Autowired
    public AmqpTemplate amqpTemplate;

    @Test
    public void sendTopicMessage() {
        for (int i = 0; i < 10; i++) {
            String message = "mson " + i;
            amqpTemplate.convertAndSend(TopicBroadcastingReceiver.BROADCASTING_EXCHANGE, TopicBroadcastingReceiver.BROADCASTING_ROUTING_KEY, message);
            System.out.printf("exchange: %s, routingKey: %s, message: %d \n",
                    TopicBroadcastingReceiver.BROADCASTING_EXCHANGE, TopicBroadcastingReceiver.BROADCASTING_ROUTING_KEY, i);
        }
    }
}
