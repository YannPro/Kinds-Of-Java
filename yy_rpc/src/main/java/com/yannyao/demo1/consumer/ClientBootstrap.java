package com.yannyao.demo1.consumer;

import com.yannyao.demo1.publicinterface.HelloService;

/**
 * @Auther: YJY
 * @Date: 2018/11/12 13:51
 * @Description:
 */
public class ClientBootstrap {

    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) {

        RpcConsumer consumer = new RpcConsumer();
        // 创建一个代理对象
        HelloService service = (HelloService) consumer
                .createProxy(HelloService.class, providerName);
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(service.hello("are you ok ?"));
        }
    }
}