package com.yannyao.demo.kafka.spring_kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ServerApplication {
    @Autowired
    private KafkaSender kafkaSender;


    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    //然后每隔1分钟执行一次
    @Scheduled(fixedRate = 1000 * 60)
    public void testKafka() throws Exception {
        kafkaSender.sendTest();
    }
}