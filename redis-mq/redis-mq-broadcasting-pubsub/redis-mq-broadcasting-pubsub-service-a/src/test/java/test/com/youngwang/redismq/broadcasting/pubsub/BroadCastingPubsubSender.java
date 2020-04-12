package test.com.youngwang.redismq.broadcasting.pubsub;

import com.youngwang.redismq.broadcasting.pubsub.service.a.BroadcastingPubsubReceiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王治杨
 * @since 2020-04-07 21:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@SpringBootApplication
public class BroadCastingPubsubSender {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void sendMessage() {
        for (int i = 0; i < 10; i++) {
            String message = "BroadCastingPubsub " + i;
            redisTemplate.convertAndSend(BroadcastingPubsubReceiver.BROADCASTING_PUBSUB_MQ_KEY, message);
            System.out.printf("send message BroadCastingPubsub %d \n", i);
        }
    }
}
