package com.yannyao.demo.alimns.mq;

import com.yannyao.demo.alimns.mq.mns.MnsConsumer;
import com.yannyao.demo.alimns.mq.mns.MnsProducer;

public class TestMQ {
    public static void main(String[] args) {
        MnsProducer producer = new MnsProducer();
        producer.producer("yann-statistic", "{'name': 'a'}");

        MnsConsumer consumer = new MnsConsumer() {
            @Override
            public String queueName() {
                return "testqueue";
            }

            @Override
            protected Class msgClass() {
                return null;
            }

            @Override
            public boolean handler(Object o) {
                return false;
            }
        };
    }
}
