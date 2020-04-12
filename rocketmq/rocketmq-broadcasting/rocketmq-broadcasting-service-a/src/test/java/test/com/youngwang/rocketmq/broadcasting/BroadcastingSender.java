package test.com.youngwang.rocketmq.broadcasting;

import com.youngwang.rocketmq.broadcasting.service.a.BroadcastingReceiver;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王治杨
 * @since 2020-04-12 21:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@SpringBootApplication
public class BroadcastingSender {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void sendTopicAMessage() {
        for (int i = 0; i < 10; i++) {
            String message = "broadcasting " + i;
            rocketMQTemplate.syncSend(BroadcastingReceiver.BROADCASTING_TOPIC, message);
            System.out.printf("topic: %s, message: %d \n", BroadcastingReceiver.BROADCASTING_TOPIC, i);
        }
    }

}
