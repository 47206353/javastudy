package com.ws.springBatch.txtfile.batch;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by hp on 2015/3/16.
 */
public class MessageWriter implements ItemWriter<Message> {

    public void write(List<? extends Message> items) throws Exception {
        System.out.println("Results:");
        for (Message item : items) {
            System.out.println(item.getContent());
        }
    }
}

