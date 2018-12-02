package com.yannyao.kafka.controller;

import com.yannyao.kafka.BaseProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @Auther: YJY
 * @Date: 2018/11/22 11:12
 * @Description:
 */
@RestController
@RequestMapping("/demo")
public class KafkaController {

    @Autowired
    private BaseProducer baseProducer;

    @GetMapping(value = "/produce")
    public Map produceMessages(@RequestParam(value = "count", required = false) Integer count) throws ExecutionException, InterruptedException {
        Map<String, String> jsonResponse = new HashMap<>();

        if (count == null) {
            count = 30;
        }

        int delay = 10;
        for (int i = 0; i < count; i++) {
            baseProducer.produce(Integer.toString(i));
//            Thread.sleep(delay);
        }

        jsonResponse.put("message", count + " messages produced");
        return jsonResponse;
    }

}