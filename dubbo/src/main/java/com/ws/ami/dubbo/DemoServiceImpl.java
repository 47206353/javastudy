package com.ws.ami.dubbo;

/**
 * Created by hp on 15-1-19.
 */
public class DemoServiceImpl implements DemoService{
    @Override
    public String sayHello() {

        System.out.println("hello 00!");
        return  "hello";
    }
}
