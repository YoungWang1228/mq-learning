package test.com.youngwang.rocketmq.oson;

import com.youngwang.rocketmq.oson.OsonTopicAReceiver;
import com.youngwang.rocketmq.oson.OsonTopicBReceiver;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王治杨
 * @since 2020-04-12 11:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@SpringBootApplication
public class OsonSender {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void sendTopicAMessage() {
        for (int i = 0; i < 10; i++) {
            String message = "oson " + i;
            rocketMQTemplate.syncSend(OsonTopicAReceiver.OSON_TOPIC_A, message);
            System.out.printf("topic: %s, message: %d \n", OsonTopicAReceiver.OSON_TOPIC_A, i);
        }
    }

    @Test
    public void sendTopicBMessage() {
        for (int i = 0; i < 10; i++) {
            String message = "oson " + i;
            rocketMQTemplate.syncSend(OsonTopicBReceiver.OSON_TOPIC_B, message);
            System.out.printf("topic: %s, message: %d \n", OsonTopicBReceiver.OSON_TOPIC_B, i);
        }
    }
}
