package com.ws.springBatch.txtfile.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by hp on 2015/3/16.
 */
public class UserMapper implements FieldSetMapper<User> {

    public void say() {
        System.out.println("ddd");
    }

    @Override
    public User mapFieldSet(FieldSet fieldSet) throws BindException {
        User user = new User();
        user.setName(fieldSet.readString(0));
        user.setAge(fieldSet.readInt(1));
        return user;
    }
}
