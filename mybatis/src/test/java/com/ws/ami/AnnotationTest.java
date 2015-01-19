package com.ws.ami;

import com.ws.ami.persistence.model.TestBean;
import com.ws.ami.persistence.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



/**
 * mybatis注解测试
 * Created by hp on 2015/1/6.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-mybatis-db.xml")
public class AnnotationTest {


    @Autowired
    TestMapper testMapper;

    @Test
    public void getSql() {
        List<TestBean> list = testMapper.getAll();

    }


    @Test
    public void insert() {
        SimpleDateFormat  sf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS");


        for (int i = 0; i <= 100; i++) {
            TestBean b = new TestBean( sf.format(new Date()), "test_text");
            Integer result = testMapper.insert(b);
            System.out.println(result);
        }

    }


    @Test
    public void insertByException() throws Exception{
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS");


        TestBean b = new TestBean(sf.format(new Date()), "test_text_exception1");
        Integer result1 = testMapper.insert(b);

        if(true)
        throw  new Exception("抛出一个异常");

        TestBean b2 = new TestBean(sf.format(new Date()), "test_text_exception1");
        Integer result2 = testMapper.insert(b2);
        System.out.println(result2);
    }


}
