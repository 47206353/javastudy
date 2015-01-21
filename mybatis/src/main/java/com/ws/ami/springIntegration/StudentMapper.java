package com.ws.ami.springIntegration;

import com.ws.ami.first.Student;

/**
 * Created by hp on 2015/1/13.
 */
public interface StudentMapper {
    public com.ws.ami.first.Student getById(int id);

    public com.ws.ami.first.Student insert(com.ws.ami.first.Student student);


    public void update(Student student);
}
