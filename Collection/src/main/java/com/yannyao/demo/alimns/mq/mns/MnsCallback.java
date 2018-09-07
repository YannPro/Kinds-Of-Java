package com.yannyao.demo.alimns.mq.mns;

import com.aliyun.mns.client.AsyncCallback;
import com.aliyun.mns.model.Message;

/**
 * create by jsm on 2018/7/3
 */
public class MnsCallback implements AsyncCallback <Message> {
    @Override
    public void onSuccess(Message msg) {
    }

    @Override
    public void onFail(Exception e) {
        System.out.println("fail");
    }
}
