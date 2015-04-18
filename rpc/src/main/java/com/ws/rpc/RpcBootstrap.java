package com.ws.rpc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hp on 2015/2/25.
 */
public class RpcBootstrap {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring_rpc.xml");
    }
}
