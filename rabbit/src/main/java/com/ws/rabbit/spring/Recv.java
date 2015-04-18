package com.ws.rabbit.spring;

/**
 * Created by hp on 2015/3/10.
 */

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Recv {

    private final static String QUEUE_NAME = "queue_one";

    private static MessageConverter messageConverter = new SimpleMessageConverter();

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(
                        "spring/spring.xml");

        RabbitTemplate rabbitTempalte = (RabbitTemplate) applicationContext.getBean("rabbitTemplate");

        Message message = rabbitTempalte.receive(QUEUE_NAME);

        Object obj = messageConverter.fromMessage(message);

        System.out.println("received:[" + obj + "]");

    }
}
