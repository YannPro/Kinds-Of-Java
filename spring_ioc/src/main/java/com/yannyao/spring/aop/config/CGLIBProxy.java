package com.yannyao.spring.aop.config;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: YJY
 * @Date: 2018/11/7 17:53
 * @Description:
 */
public class CGLIBProxy implements MethodInterceptor {
    private Object target;
    private ProxyUtil proxyUtil;

    public CGLIBProxy(Object target) throws ClassNotFoundException {
        this.target = target;
        proxyUtil = new ProxyUtil();
    }

    public <T> T getProxy() {
        // 这行代码很重要!!!  有一个回调函数   会走到intercept中
        Object object = new Enhancer().create(this.target.getClass(), this);
        return (T) object;
    }

    public <T> T getProxy(Class<?> clazz) {
        return (T) new Enhancer().create(this.target.getClass(), this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        ProxyEntity proxyEntity = new ProxyEntity(proxy, this.target.getClass(), obj, method, args);
        return proxyUtil.generateEntity(proxyEntity);
    }
}