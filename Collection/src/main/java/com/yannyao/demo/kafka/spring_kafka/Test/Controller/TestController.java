package com.yannyao.demo.kafka.spring_kafka.Test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    KafkaTemplate kafkaTemplate;

//    private Gson gson = new GsonBuilder().create();

    @RequestMapping("/Kafka")
    @ResponseBody
    public void testkafka() throws Exception {
//        BiddingUserBean bean = new BiddingUserBean();
//        bean.setId(110L);
//        bean.setCproductname("腾讯");
//        bean.setIphone("18888888888");
        kafkaTemplate.send("springboot_test", "{'a',1}");
    }

}
