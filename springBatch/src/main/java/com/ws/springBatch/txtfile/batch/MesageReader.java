package com.ws.springBatch.txtfile.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

/**
 * Created by hp on 2015/3/16.
 */
@Service
public class MesageReader implements ItemReader<User> {

    static int count = 0;

    @Override
    public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        count++;
        if (count < 10) {
            User u = new User();
            u.setAge(10);
            u.setName("hello");
            return u;
        }
        return null;
    }
}
