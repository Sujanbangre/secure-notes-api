package com.sujan.securenotes.redis;

import jakarta.annotation.PostConstruct;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisConsumer {

    private final StringRedisTemplate redisTemplate;

    public RedisConsumer(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void startConsumer() {

        Thread thread = new Thread(() -> {

            while (true) {

                try {

                    String message =
                            redisTemplate.opsForList().leftPop("notes");

                    if (message != null) {

                        System.out.println();
                        System.out.println("================================");
                        System.out.println("ADMIN EVENT");
                        System.out.println("================================");
                        System.out.println(message);
                        System.out.println("================================");
                        System.out.println();

                    }

                    Thread.sleep(1000);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

        thread.setDaemon(true);
        thread.start();

    }
}
