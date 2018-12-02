package com.yannyao.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: YJY
 * @Date: 2018/11/22 11:13
 * @Description:
 */
public class BaseConsumer implements Runnable {
    private final int id;
    private final List<String> topics;
    private final KafkaConsumer<String, String> consumer;

    public BaseConsumer(int id,
                        List<String> topics,
                        Properties consumerProps
    ) {
        this.id = id;
        this.topics = topics;
        this.consumer = new KafkaConsumer<>(consumerProps);
    }

    @Override
    public void run() {
        try {
            System.out.println("Consumer with ID: " + id + ". started");
            consumer.subscribe(topics);

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
                for (ConsumerRecord<String, String> record : records) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("partition", record.partition());
                    data.put("offset", record.offset());
                    data.put("value", record.value());
                    System.out.println(this.id + ": " + data);
                }
            }
        } catch (WakeupException e) {
            // ignore for shutdown
        } finally {
            consumer.close();
        }
    }

    public void shutdown() {
        consumer.wakeup();
    }
}