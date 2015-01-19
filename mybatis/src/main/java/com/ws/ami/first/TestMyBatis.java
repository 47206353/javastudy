package com.ws.ami.first;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * 第一个mybatis
 * Created by hp on 2015/1/13.
 */
public class TestMyBatis {


    public static void main(String[] args) throws Exception {


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
        Student student = mapper.getById(1);
        sqlSession.close();
    }


    private static void add() {
        SqlSession sqlSession = getSession();
        Student student = new Student();
        student.setName("陈一斌");
        student.setGender("男");
        student.setMajor("计算机科学与技术");
        student.setGrade("2011");
        StudentMapper mapper =
                sqlSession.getMapper(StudentMapper.class);
        mapper.add(student);
//提交事务，否则不会实际添加到数据库中
        sqlSession.commit();
        System.out.println("数据库生成的ID： "
                + student.getId());
        sqlSession.close();
    }
}
