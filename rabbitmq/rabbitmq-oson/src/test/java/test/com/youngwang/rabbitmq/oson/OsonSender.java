package test.com.youngwang.rabbitmq.oson;

import com.youngwang.rabbitmq.oson.DirectOsonReceiver;
import com.youngwang.rabbitmq.oson.TopicOsonReceiver;
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
public class OsonSender {

    @Autowired
    public AmqpTemplate amqpTemplate;

    @Test
    public void sendDirectMessage() {
        for (int i = 0; i < 10; i++) {
            String message = "oson " + i;
            amqpTemplate.convertAndSend(DirectOsonReceiver.OSON_DIRECT_QUEUE, message);
            System.out.printf("direct: %s, message: %d \n", DirectOsonReceiver.OSON_DIRECT_QUEUE, i);
        }
    }

    @Test
    public void sendTopicMessage() {
        for (int i = 0; i < 10; i++) {
            String message = "oson " + i;
            amqpTemplate.convertAndSend(TopicOsonReceiver.OSON_TOPIC_EXCHANGE, TopicOsonReceiver.OSON_TOPIC_ROUTING_KEY, message);
            System.out.printf("exchange: %s, routingKey: %s, message: %d \n",
                    TopicOsonReceiver.OSON_TOPIC_EXCHANGE, TopicOsonReceiver.OSON_TOPIC_ROUTING_KEY, i);
        }
    }
}
