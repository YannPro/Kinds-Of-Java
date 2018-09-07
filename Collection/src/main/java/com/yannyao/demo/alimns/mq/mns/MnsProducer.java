package com.yannyao.demo.alimns.mq.mns;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ClientException;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.*;
import com.aliyun.mns.sample.HttpEndpoint;
import com.yannyao.demo.alimns.mq.Producer;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;

/**
 * create by jsm on 2018/7/2
 */
@Component
public class MnsProducer implements Producer<String> {
    //    @Resource
//    private MnsClient mnsClient;
    static BASE64Encoder base64Encoder = new BASE64Encoder();

    @Override
    public void producer(String topic, String msg) {
        MnsClient mnsClient = new MnsClient();
        MNSClient client = mnsClient.getClient();
        CloudTopic cloudTopic = client.getTopicRef(topic);
        TopicMessage tMessage = new RawTopicMessage();
        tMessage.setBaseMessageBody(base64Encoder.encode(msg.getBytes()));
        cloudTopic.publishMessage(tMessage);
    }

    public static void main(String[] args) {
        String accessKeyId = "LTAIREJ7tDfAJgpW";
        String accessKeySecret = "2QyCAzNR3BqX1EZd9GILM4QYgU5h1J";
        String endpoint = "http://1717307086142943.mns.cn-hangzhou.aliyuncs.com/";
        CloudAccount account = new CloudAccount(accessKeyId, accessKeySecret, endpoint);
        MNSClient client = account.getMNSClient();
        TopicMessage tMessage = new RawTopicMessage();
        tMessage.setBaseMessageBody(base64Encoder.encode("测试base64".getBytes()));
        CloudTopic topic = client.getTopicRef("testtopic");
        topic.publishMessage(tMessage);
        System.out.println("---------------------消息发送完毕-----------------");
    }

}
