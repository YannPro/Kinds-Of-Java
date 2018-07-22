package com.yannyao.demo.kafka.spring_kafka;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {

    /**
     * 监听test主题,有消息就读取
     * @param message
     */
    @KafkaListener(topics = {"t5"})
    public void consumer(String message){
        System.out.println("test topic message : {}"+ message);
    }
}