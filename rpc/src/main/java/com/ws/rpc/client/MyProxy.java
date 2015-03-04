package com.ws.rpc.client;

import com.ws.rpc.model.RpcRequest;
import com.ws.rpc.model.RpcResponse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

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
        RpcRequest request = new RpcRequest(); // 创建并初始化 RPC 请求
        request.setRequestId(UUID.randomUUID().toString());
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameterTypes(method.getParameterTypes());
        request.setParameters(args);
        RpcClient client = new RpcClient("127.0.0.1", 8080); // 初始化 RPC 客户端
        RpcResponse response =null;
        response = client.send(request); // 通过 RPC 客户端发送 RPC 请求并获取 RPC 响应*/
        return  response;

    }


}
