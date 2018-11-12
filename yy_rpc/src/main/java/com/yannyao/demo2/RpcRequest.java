package com.yannyao.demo2;

import java.io.Serializable;

/**
 * @Auther: YJY
 * @Date: 2018/11/12 15:54
 * @Description:统一传输对象（让服务端知道当前要做什么）
 */
public class RpcRequest implements Serializable {

    private String className;
    private String methodName;
    private Object[] parameters;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}