package com.ws.ami.persistence.dao;

import com.ws.ami.persistence.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by hp on 2015/1/7.
 */
public interface IUserDAO {

    //最基本的注解CRUD

        @Select("select *from User")
        public List<User> retrieveAllUsers();

        //注意这里只有一个参数，则#{}中的标识符可以任意取
        @Select("select *from User where id=#{idss}")
        public User retrieveUserById(int id);

        @Select("select *from User where id=#{id} and userName like #{name}")
        public User retrieveUserByIdAndName(@Param("id")int id,@Param("name")String names);

        @Insert("INSERT INTO user(userName,userAge,userAddress) VALUES(#{userName},"
                + "#{userAge},#{userAddress})")
        public void addNewUser(User user);

        @Delete("delete from user where id=#{id}")
        public void deleteUser(int id);

       // @Update("update user set userName=#{userName},userAddress=#{userAddress} where id=#{id}")


}
