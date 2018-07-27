package com.yannyao.demo.kafka.spring_kafka.Test;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaListeners {


    @KafkaListener(topics = {"springboot_test"})
    public void processMessage(String content) {
        System.out.println("接受:"+content);
    }

}