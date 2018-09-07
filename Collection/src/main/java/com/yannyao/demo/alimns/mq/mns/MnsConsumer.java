package com.yannyao.demo.alimns.mq.mns;

import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.model.Message;
import com.xiaoju.automarket.knife.util.JsonUtil;
import com.yannyao.demo.alimns.mq.Consumer;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * create by jsm on 2018/7/2
 */
@Component
public abstract class MnsConsumer<T> implements Consumer<T> {
    BASE64Decoder base64Decoder = new BASE64Decoder();
    @Resource
    private MnsClient mnsClient;
    private CloudQueue queue;

    @PostConstruct
    public void init() {
        MNSClient client = this.mnsClient.getClient();
        queue = client.getQueueRef(queueName());
        consumer();
    }

    public abstract String queueName();

    @Override

    public void consumer() {
        new Thread(() -> {
            while (true) {
                try {
                    if (queue == null) {
                        break;
                    }
                    Message message = queue.popMessage(1);
                    if (message != null) {
                        System.out.println(message.getMessageBodyAsRawString());


                        boolean success = handler(JsonUtil.fromJson(new String(base64Decoder.decodeBuffer(message.getMessageBodyAsRawString())), msgClass()));
                        if (success) {
                            queue.deleteMessage(message.getReceiptHandle());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    protected abstract Class <T> msgClass();

    public abstract boolean handler(T t);


}
