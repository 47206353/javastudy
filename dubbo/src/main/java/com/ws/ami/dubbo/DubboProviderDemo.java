package com.ws.ami.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hp on 15-1-19.
 */
public class DubboProviderDemo {
    public static void main(String[] args) throws InterruptedException {

        new ClassPathXmlApplicationContext(
                new String[] {"config/provider.xml"});
        while (true){}

    }
}
