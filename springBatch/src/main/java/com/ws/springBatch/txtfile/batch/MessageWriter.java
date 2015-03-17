package com.ws.springBatch.txtfile.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by hp on 2015/3/16.
 */
@Slf4j
public class MessageWriter implements ItemWriter<Message> {

    public void write(List<? extends Message> items) throws Exception {
        log.info("start log write message, items.size = " + items.size());
        for (Message message : items)
            log.info("message =" + message.toString());
        log.info("write message end");

    }
}

