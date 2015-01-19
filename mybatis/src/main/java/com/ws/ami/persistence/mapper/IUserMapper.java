package com.ws.ami.persistence.mapper;


import com.ws.ami.persistence.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserMapper {
	//请注意，这里面有一个方法名 selectUserByID 必须与 User.xml 
	//里面配置的 select 的id 对应（<select id="selectUserByID"）
    public User selectUserByID(int id);
    
    
    
    public List<User> selectUsers(String userName);
    
    
    public List<User> selectUserbyid(@Param("userName") String userName, @Param("id") int id);
    
    
    public void addUser(User user);
    
}