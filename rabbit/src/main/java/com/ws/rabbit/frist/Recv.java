package com.ws.rabbit.frist;

/**
 * Created by hp on 2015/3/10.
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {

    //消息队列名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws java.io.IOException, java.lang.InterruptedException {

        //创建链接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //创建链接
        Connection connection = factory.newConnection();

        //创建消息信道
        Channel channel = connection.createChannel();

        //生命消息队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("[*] Waiting for message. To exist press CTRL+C");

        //消费者用于获取消息信道绑定的消息队列中的信息
        QueueingConsumer consumer = new QueueingConsumer(channel);

        channel.basicConsume(QUEUE_NAME, true, consumer);

        int i = 0;
        while (true) {

            //循环获取消息队列中的信息
            i++;
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" i =" + i + " [x] Received '" + message + "'");

        }

    }

}
