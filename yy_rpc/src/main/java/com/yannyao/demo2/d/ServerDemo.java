package com.yannyao.demo2.d;

import com.yannyao.demo2.RpcServer;

/**
 * @Auther: YJY
 * @Date: 2018/11/12 15:57
 * @Description:
 */
public class ServerDemo {
    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer();
        rpcServer.publisher(new HelloServiceImpl(),12345);
    }
}
