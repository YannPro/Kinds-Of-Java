package com.yannyao.demo.kafka;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.alibaba.fastjson.JSON;

public class KafkaProduce {
    private static Properties properties;

    static {
        properties = new Properties();
//        String path = KafkaProduce.class.getResource("/").getFile().toString() + "kafka.properties";
        try {InputStream in = new BufferedInputStream(new FileInputStream(
                new File("F:\\Kinds-Of-Java\\Collection\\src\\main\\resources\\kafka.properties")));
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息
     *
     * @param topic
     * @param key
     * @param value
     */
    public void sendMsg(String topic, String key, String value) {

        System.err.println("properties:" + JSON.toJSONString(properties));
        // 实例化produce
        KafkaProducer<String, String> kp = new KafkaProducer<String, String>(properties);
        System.err.println("kp:" + JSON.toJSONString(kp));

        // 消息封装
        ProducerRecord<String, String> pr = new ProducerRecord<String, String>(topic, key, value);

        // 发送数据
        //        kp.send(pr);
        kp.send(pr, new Callback() {
            // 回调函数
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (null != exception) {
                    System.out.println("记录的offset在:" + metadata.offset());
                    System.out.println(exception.getMessage() + exception);
                }
            }
        });

        // 关闭produce
        kp.close();
    }
}