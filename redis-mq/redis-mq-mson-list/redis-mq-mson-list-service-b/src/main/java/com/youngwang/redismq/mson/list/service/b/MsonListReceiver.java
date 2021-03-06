package com.youngwang.redismq.mson.list.service.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author 王治杨
 * @since 2020-04-07 21:19
 */
@Component
public class MsonListReceiver implements Runnable {

    public static final String MSON_LIST_MQ_KEY = "MSON_LIST_MQ_SERVICE_B_KEY";

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    private volatile boolean shutdown;


    @PostConstruct
    public void init() {
        new Thread(this).start();
    }

    @PreDestroy
    public void destroy() {
        shutdown = true;
    }

    @Override
    public void run() {
        while (!shutdown) {
            Object obj = redisTemplate.boundListOps(MSON_LIST_MQ_KEY).rightPop(1, TimeUnit.SECONDS);
            if (Objects.nonNull(obj)) {
                System.out.printf("%s get message : %s \n", Thread.currentThread().getName(), obj);
            }
        }
    }
}
