package com.ws.springBatch.txtfile.batch;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by hp on 2015/3/16.
 */
public class MessageProcessor implements ItemProcessor<User, Message> {

    public Message process(User item) throws Exception {
        Message message = null;
        // if (item.getAge() > 16) {
        message = new Message();
        message.setContent(item.getName() + ",Please come to police station!");
        message.setAge(item.getName());
        message.setName(item.getName());
        //  }
        return message;
    }
}
