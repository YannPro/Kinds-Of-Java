package com.yannyao.demo2.d;

import com.yannyao.demo2.RpcClientProxy;

/**
 * @Auther: YJY
 * @Date: 2018/11/12 15:57
 * @Description:
 */
public class ClientDemo {
    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy();
        IHelloService helloService = proxy.clientProxy(IHelloService.class, "127.0.0.1", 12345);
        String name = helloService.sayHello("张三");
        System.out.println(name);
    }
}
