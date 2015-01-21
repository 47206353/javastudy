package com.ws.ami.springIntegration;

import com.ws.ami.first.Student;
import com.ws.ami.first.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Reader;

/**
 * 第一个mybatis
 * Created by hp on 2015/1/13.
 */
public class TestMyBatis {

    private static ApplicationContext ctx;

    static {
//在类路径下寻找resources/beans.xml文件
        ctx = new ClassPathXmlApplicationContext("springIntegration/spring-mybatis-db.xml");
    }


   /* public static void main(String[] args) throws Exception {


        select();
        add();


    }

    private static SqlSession getSession() {
        //与configuration.xml中的mapper配置类似，告诉MyBatis
        //应读取的核心配置文件
        //创建SqlSessionFactory实例。没有指定要用到的
        //environment，则使用默认的environment
        String resource = "first/first_configuration.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            return sqlSession;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;

    }

    private static void select() {

        SqlSession sqlSession = getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        com.ws.ami.first.Student student = mapper.getById(1);
        sqlSession.close();
    }


    private static void add() {
        SqlSession sqlSession = getSession();
        com.ws.ami.first.Student student = new Student();
        student.setName("陈一斌");
        student.setGender("男");
        student.setMajor("计算机科学与技术");
        student.setGrade("2011");
        StudentMapper mapper =
                sqlSession.getMapper(StudentMapper.class);
        //mapper.add(student);
//提交事务，否则不会实际添加到数据库中
        sqlSession.commit();
        System.out.println("数据库生成的ID： "
                + student.getId());
        sqlSession.close();
    }*/
}
