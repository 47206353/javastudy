package com.ws.rpc.client;

import com.ws.rpc.HelloService;
import com.ws.rpc.HelloServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Objects;

/**
 * Created by hp on 2015/2/25.
 */
public class HelloServiceTest {


    public static void main(String[] args) throws Exception {



 /*       RpcProxy  rpcProxy = new RpcProxy();
        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.hello("World");*/

        MyProxy proxy = new MyProxy();

        Object oqqqq = proxy.factory(new HelloServiceImpl());
        HelloService helloService = (HelloService) proxy.factory(new HelloServiceImpl());
        String result = helloService.hello("World");

    }
}
