package com.ws.ami.dubbo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hp on 15-1-19.
 */
public class DubboComsumeDemo {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext factory = new ClassPathXmlApplicationContext(
                new String[] {"config/consumer.xml"});

        DemoService demoService = (DemoService) factory.getBean("demoService");
        demoService.sayHello();

    }
}
