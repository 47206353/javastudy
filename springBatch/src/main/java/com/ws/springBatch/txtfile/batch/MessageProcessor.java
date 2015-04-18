package com.ws.springBatch.txtfile.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by hp on 2015/3/16.
 */
@Slf4j
public class MessageProcessor implements ItemProcessor<User, Message> {

    private static int count = 0;

    public Message process(User item) throws Exception {
        count++;
        log.info("count = " + count + " item = " + item.toString());
        Message message = null;
        // if (item.getAge() > 16) {
        message = new Message();
        message.setContent(item.getName() + ",Please come to police station!");
        message.setAge(item.getName());
        message.setName(item.getName());
        // Thread.sleep(30000);

        if (count == 8)
            throw new Exception("my exception ");

        return message;
    }
}
