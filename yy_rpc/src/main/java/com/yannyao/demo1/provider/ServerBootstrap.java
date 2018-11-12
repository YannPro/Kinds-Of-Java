package com.yannyao.demo1.provider;

import com.yannyao.demo1.netty.NettyServer;

/**
 * @Auther: YJY
 * @Date: 2018/11/12 12:03
 * @Description:
 */
public class ServerBootstrap {
    public static void main(String[] args) {
        NettyServer.startServer("localhost", 7777);
    }
}
