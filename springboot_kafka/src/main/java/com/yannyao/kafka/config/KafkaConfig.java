package com.yannyao.kafka.config;

import com.yannyao.kafka.BaseConsumer;
import com.yannyao.kafka.BaseProducer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: YJY
 * @Date: 2018/11/22 11:28
 * @Description:
 */
@Configuration
public class KafkaConfig {
//    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;
    @Value("${kafka.topic.name}")
    private String topic;
    @Value("${kafka.producer.mode}")
    private String sync;
    @Value("${kafka.consumer.number}")
    private int numConsumers = 3;
    @Value("${kafka.consumer.group.id}")
    private String consumerGroupId;

    @Value("${a}")
    private int a;
    // We are having just one consumer exposed with a controller to put X elements into the topic
    private BaseProducer baseProducer;

    // Consumers are async, so we are creating them in a list that we are gonna insert in a Thread Pool
    private List<BaseConsumer> baseConsumers = new ArrayList<>();

    // This is the Thread Pool we we are gonna insert the consumers
    private ExecutorService executorService = Executors.newFixedThreadPool(numConsumers);

    @Bean
    public BaseProducer baseProducer() throws ExecutionException, InterruptedException {
        Properties producerProps = new Properties();
        producerProps.put("bootstrap.servers", bootstrapServers);

        // This is mandatory, even though we don't send keys
        producerProps.put("key.serializer", StringSerializer.class.getName());
        producerProps.put("value.serializer", StringSerializer.class.getName());
        producerProps.put("acks", "1");

        // how many times to retry when produce request fails?
        producerProps.put("retries", "3");
        producerProps.put("linger.ms", 5);

        baseProducer = new BaseProducer(topic, producerProps, sync);
        baseProducer.start();
        System.out.println("Starting Producer...");
        baseProducer.produce("Starting Producer...");
        return baseProducer;
    }

    @Bean
    public List<BaseConsumer> baseConsumers() {
        Properties consumerProps = new Properties();
        consumerProps.put("bootstrap.servers", bootstrapServers);
        consumerProps.put("group.id", consumerGroupId);
        consumerProps.put("key.deserializer", StringDeserializer.class.getName());
        consumerProps.put("value.deserializer", StringDeserializer.class.getName());

        for (int i = 0; i < numConsumers; i++) {
            BaseConsumer baseConsumer = new BaseConsumer(i, Arrays.asList(topic), consumerProps);
            baseConsumers.add(baseConsumer);
            executorService.submit(baseConsumer);
        }
        return baseConsumers;
    }

    @PreDestroy
    public void shutdownThis() throws ExecutionException, InterruptedException {
        // Shutdown producer
        System.out.println("Closing down Producer...");
        baseProducer.close();
        System.out.println("Producer closed!");

        // Shutdown consumers
        System.out.println("Shutting down consumers...");

        // We first call the shutdown method created in the consumer
        for (BaseConsumer consumer :
                baseConsumers) {
            consumer.shutdown();

        }

        // Then we call the shutdown on the executor service
        executorService.shutdown();

        System.out.println("Consumers stopped");
    }
}
