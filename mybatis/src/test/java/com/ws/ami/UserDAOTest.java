package com.ws.ami;

import com.ws.ami.persistence.mapper.IUserMapper;
import com.ws.ami.persistence.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.List;


/**
 * mybatis 学习
 * Created by hp on 2015/1/5.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)*/

public class UserDAOTest {


    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {

        try {
            reader = Resources.getResourceAsReader("db/configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 第一个例子
     */
    @Test
    public void firstTest() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = (User) session.selectOne(
                    "com.ws.ami.mybitis.model.User.UserMapper.selectUserByID", 1);
            System.out.println(user.getUserAddress());
            System.out.println(user.getUserName());
        } finally {
            session.close();
        }
    }

    /**
     * 以接口编程例子
     */
    @Test
    public void test2() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserMapper iUserMapper = session.getMapper(IUserMapper.class);
            User user = iUserMapper.selectUserByID(1);
            System.out.println(user.getUserAddress());
            System.out.println(user.getUserName());
        } finally {
            session.close();
        }
    }

    /**
     * 得到list
     */
    @Test
    public void getList() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserMapper iUserMapper = session.getMapper(IUserMapper.class);
            List<User> users = iUserMapper.selectUsers("summer");
            System.out.println("list.size=" + users.size());
            User user = users.get(0);
            System.out.println("list.size=" + user.getUserName());

        } finally {
            session.close();
        }

    }

    /**
     * 得到list
     */
    @Test
    public void getListbyName() {

        String name = "name";
        int id = 1;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserMapper iUserMapper = session.getMapper(IUserMapper.class);
            List<User> users = iUserMapper.selectUserbyid(name, id);
            System.out.println("list.size=" + users.size());
            User user = users.get(0);
            System.out.println("list.size=" + user.getUserName());

        } finally {
            session.close();
        }

    }

    @Test
    public void addUser() {
        SqlSession session = sqlSessionFactory.openSession();
        User u = new User();
        u.setUserAddress("hunan");
        u.setUserAge("20");
        u.setUserName("h");
        IUserMapper iUserMapper = session.getMapper(IUserMapper.class);
        iUserMapper.addUser(u);
        System.out.println("增加成功 ");


    }

}
