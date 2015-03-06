package com.ws.springIntegeration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;

//标记 MessageEndpoint 元数据， input表示 设置后所有 orders Channel消息都会被OrderSplitter收到
       @MessageEndpoint
       public class OrderSplitter {

                        //@Splitter表示,接收消息后，调用这个类的该方法. 其的参数类型必须与message的 payload属性一致。
                       //即在new GenericMessage<T>的泛型中指定
                      //元数据设置的 channel属性表示，方法执行完成后，会把方法返回的结果保存到message的payload属性后，发送到指定的channel中去
                        //这里指定发送到 drinks channel
                         @Splitter()
            public List<Drink> split(DrinkOrder order) {
                         return order.getDrinks(); //方法中，是把订单中的饮料订单取出来
                    }
            }
