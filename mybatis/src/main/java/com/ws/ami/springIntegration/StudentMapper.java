package com.ws.ami.springIntegration;



/**
 * Created by hp on 2015/1/13.
 */
public interface StudentMapper {
    public Student getById(int id);

    public Student insert(Student student);


    public void update(Student student);
}
