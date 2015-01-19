package com.ws.ami.persistence.dao;

import com.ws.ami.persistence.mapper.TestMapper;
import com.ws.ami.persistence.model.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hp on 2015/1/12.
 */
@Service("testDAO")
public class TestDAO {
    @Autowired
    TestMapper mapper;


    public void insert() throws Exception {


        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS");


        TestBean b = new TestBean(sf.format(new Date()), "test_text_exception1");
        Integer result1 = mapper.insert(b);

        if (true)
            throw new Exception("抛出一个异常");

        TestBean b2 = new TestBean(sf.format(new Date()), "test_text_exception1");
        Integer result2 = mapper.insert(b2);
        System.out.println(result2);
    }


}