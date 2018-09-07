package com.yannyao.demo.alimns.mq.mns;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * create by jsm on 2018/7/2
 */
@Component
public class MnsClient {
    String accessKeyId = "LTAIREJ7tDfAJgpW";
    String accessKeySecret = "2QyCAzNR3BqX1EZd9GILM4QYgU5h1J";
    String endpoint = "http://1717307086142943.mns.cn-hangzhou.aliyuncs.com/";
    MNSClient client;

    @PostConstruct
    public void init() {
        System.out.println("---------------------endpoint:" + endpoint);
        CloudAccount account = new CloudAccount(accessKeyId, accessKeySecret, endpoint);
        client = account.getMNSClient();
    }


    public MNSClient getClient() {

        return client;
    }

    public static void main(String[] args) {
        CloudAccount account = new CloudAccount("LTAIREJ7tDfAJgpW", "2QyCAzNR3BqX1EZd9GILM4QYgU5h1J", "http://1717307086142943.mns.cn-hangzhou.aliyuncs.com/");
        MNSClient client = account.getMNSClient();

        new Thread(() -> {
            CloudQueue queue = client.getQueueRef("testqueue");
            while (true) {
                try {
                    if (queue == null) {
                        System.out.println("bdasdsa");
                        break;
                    }
                    Message message = queue.popMessage();
                    System.out.println("收到消息之前"+queue.getAttributes());
                    if (message != null) {
                        System.out.println("收到消息了");
                        System.out.println(message.getMessageBodyAsRawString());
                        JSONObject jsonObject = JSONObject.parseObject(message.getMessageBodyAsRawString());

//                    queue.deleteMessage(message.getReceiptHandle());
                    }
                } catch (Exception e) {

                }
            }
        }).start();

    }

}
