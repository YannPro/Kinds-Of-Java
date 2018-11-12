package com.yannyao.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: YJY
 * @Date: 2018/11/12 15:54
 * @Description:
 */
public class RpcClientProxy {

    @SuppressWarnings("unchecked")
    public <T> T clientProxy(final Class<T> interfaceClass,final String host,final int port){
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader()
                , new Class[]{interfaceClass}
                , new InvocationHandler() {
                    /**
                     *发起客户端和服务端的远程调用。调用客户端的信息进行传输
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        RpcRequest rpcRequest = new RpcRequest();
                        rpcRequest.setClassName(method.getDeclaringClass().getName());
                        rpcRequest.setMethodName(method.getName());
                        rpcRequest.setParameters(args);
                        TcpTransport tcpTransport = new TcpTransport(host,port);
                        return tcpTransport.send(rpcRequest);
                    }

                });
    }
}
