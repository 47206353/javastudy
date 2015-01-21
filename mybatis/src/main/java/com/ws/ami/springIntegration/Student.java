package com.ws.ami.springIntegration;

/**
 * Created by hp on 2015/1/13.
 */
public class Student {
    private int id;
    private String name;   //姓名
    private String gender; //性别
    private String major;  //专业
    private String grade;  //年级
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
