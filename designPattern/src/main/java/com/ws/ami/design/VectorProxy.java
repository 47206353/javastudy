package com.ws.ami.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/**
 * 动态代理调用，
 * InvocationHandler调用处理器
 * Created by hp on 2015/1/27.
 */
public class VectorProxy implements InvocationHandler {

    private Object proxyobj;

    public VectorProxy(Object proxyobj) {
        this.proxyobj = proxyobj;
    }


    public static Object factory(Object obj) {

       return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),new VectorProxy(obj));

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling");
        Object o = method.invoke(proxy, args);
        System.out.println("after calling");
        return o;
    }

    public static void main(String[] args) {

        List v = null;
        Object a = factory(new Vector(10));
        v = (List) a;
        v.add("new ");
    }
}
