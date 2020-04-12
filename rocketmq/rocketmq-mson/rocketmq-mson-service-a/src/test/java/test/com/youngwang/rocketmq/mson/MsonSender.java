package test.com.youngwang.rocketmq.mson;

import com.youngwang.rocketmq.mson.service.a.MsonReceiver;
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
public class MsonSender {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void sendTopicAMessage() {
        for (int i = 0; i < 10; i++) {
            String message = "mson " + i;
            rocketMQTemplate.syncSend(MsonReceiver.MSON_TOPIC, message);
            System.out.printf("topic: %s, message: %d \n", MsonReceiver.MSON_TOPIC, i);
        }
    }

}
