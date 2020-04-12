package test.com.youngwang.redismq.mson.list;

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
public class MsonListSender {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void sendMessage() {
        BoundListOperations<Object, Object> listOperationsA = redisTemplate.boundListOps("MSON_LIST_MQ_SERVICE_A_KEY");
        BoundListOperations<Object, Object> listOperationsB = redisTemplate.boundListOps("MSON_LIST_MQ_SERVICE_B_KEY");
        for (int i = 0; i < 10; i++) {
            String message = "mson " + i;
            listOperationsA.leftPush(message);
            listOperationsB.leftPush(message);
            System.out.printf("send message %d \n", i);
        }
    }
}
