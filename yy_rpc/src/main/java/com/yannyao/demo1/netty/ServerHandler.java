package com.yannyao.demo1.netty;

import com.yannyao.demo1.consumer.ClientBootstrap;
import com.yannyao.demo1.publicinterface.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Auther: YJY
 * @Date: 2018/11/12 12:01
 * @Description:用于处理请求数据
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        // 如何符合约定，则调用本地方法，返回数据
        if (msg.toString().startsWith(ClientBootstrap.providerName)) {
            String result = new HelloServiceImpl()
                    .hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        }

    }
}