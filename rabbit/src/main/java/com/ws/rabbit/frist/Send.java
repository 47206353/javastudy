package com.ws.rabbit.frist;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class Send {

    //消息队列名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws java.io.IOException {

        //创建链接工程
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //创建链接
        Connection connection = factory.newConnection();
        //创建消息通道
        Channel channel = connection.createChannel();
        //生命一个消息队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World";
        //发布消息，第一个参数表示路由（Exchange名称），未""则表示使用默认消息路由
        for(int i=0;i<100;i++)
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //关闭消息通道和链接
        channel.close();
        connection.close();

    }

}
