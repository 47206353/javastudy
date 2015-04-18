package com.ws.rabbit.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hp on 2015/3/10.
 */
public class Send {
    private final static String QUEUE_NAME = "queue_one";

    private static MessageConverter messageConverter = new SimpleMessageConverter();

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(
                        "spring/spring.xml");

        RabbitTemplate rabbitTempalte = (RabbitTemplate) applicationContext.getBean("rabbitTemplate");
        String message = "Hello World!";
        rabbitTempalte.send("", QUEUE_NAME, messageConverter.toMessage(message, null));
    }
}
