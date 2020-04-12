package test.com.youngwang.redismq.broadcasting.stream;

import com.youngwang.redismq.broadcasting.stream.service.a.BroadcastingStreamReceiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.BoundStreamOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

/**
 * @author 王治杨
 * @since 2020-04-07 21:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@SpringBootApplication
public class BroadcastingStreamSender {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void sendMessage() {
        BoundStreamOperations<String, String, String> operations = redisTemplate.boundStreamOps(BroadcastingStreamReceiver.BROADCASTING_STREAM_MQ_KEY);
        for (int i = 0; i < 10; i++) {
            RecordId recordId = operations.add(Collections.singletonMap("index", String.valueOf(i)));
            System.out.printf("send message %d , message id %s\n", i, recordId);
        }
    }
}
