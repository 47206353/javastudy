package com.ws.ami.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理调用，
 * InvocationHandler调用处理器
 * Created by hp on 2015/1/27.
 */
public class MyProxy implements InvocationHandler {

    //目标类，需要被代理的类。如：xx服务
    private Object target;

  /*  public MyProxy(Object proxyobj) {
        this.proxyobj = proxyobj;
    }*/


    public Object factory(Object obj) {

        this.target = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);


    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling");
        java.lang.Class<?>[] parameter = method.getParameterTypes();
        Object o = method.invoke(target, args);
        System.out.println("after calling");
        return o;
    }


}
