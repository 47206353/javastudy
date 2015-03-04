package com.ws.rpc;

/**
 * Created by hp on 2015/2/25.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello! " + name;
    }
}
