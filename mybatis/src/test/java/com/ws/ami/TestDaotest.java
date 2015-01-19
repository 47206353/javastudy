package com.ws.ami;

import com.ws.ami.persistence.dao.TestDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hp on 2015/1/12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-mybatis-db.xml")
public class TestDaotest {

    @Autowired
    TestDAO testDAO;


    @Test
    public void test() throws Exception
    {
        testDAO.insert();

    }

}
