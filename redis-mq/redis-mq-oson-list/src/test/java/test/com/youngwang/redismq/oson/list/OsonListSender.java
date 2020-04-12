package test.com.youngwang.redismq.oson.list;

import com.youngwang.redismq.oson.list.OsonListReceiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 王治杨
 * @since 2020-04-07 21:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@SpringBootApplication
public class OsonListSender {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void sendMessage() {
        BoundListOperations<Object, Object> listOperations = redisTemplate.boundListOps(OsonListReceiver.OSON_LIST_MQ_KEY);
        for (int i = 0; i < 10; i++) {
            listOperations.leftPush("oson " + i);
            System.out.printf("send message %d \n", i);
        }
    }
}
