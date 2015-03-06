package com.ws.springIntegeration;

import org.springframework.integration.MessageChannel;

/**
 * Created by hp on 2015/3/6.
 */
public class Cafe {
    private MessageChannel orderChannel;


                   public void setOrderChannel(MessageChannel orderChannel) {
                   this.orderChannel = orderChannel;
                 }

                     //其实下订单操作，调用的是orderChannel(orders channel)的send方法，把消息发出去
                     public void placeOrder(DrinkOrder order) {
                     this.orderChannel.send(new GenericMessage<DrinkOrder>(order));
                       //GenericMessage有三个构建方法，参考如下
                       //new GenericMessage<T>(Object id, T payload);
                        //new GenericMessage<T>(T payload);
                       //new GenericMessage<T>(T payload, MessageHeader headerToCopy)
                }
        }
}
