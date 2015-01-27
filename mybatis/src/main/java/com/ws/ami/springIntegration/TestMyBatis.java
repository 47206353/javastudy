package com.ws.ami.springIntegration;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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





    public static void main(String[] args)
    {
        StudentMapper mapper =
                (StudentMapper)ctx.getBean("studentMapper");
        Student student = new Student();
        student.setId(123);
        student.setName("李林");
        student.setGender("男");
        student.setMajor("计算机科学与技术");
        student.setGrade("2011");
        Student student1 = mapper.add(student);

    }
}
