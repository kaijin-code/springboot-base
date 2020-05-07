package com.xncoding.common.dao;

import com.xncoding.common.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "time", column = "time")
    })
    @Select("SELECT * FROM user WHERE age = #{age}")
    List<User> get(int age);

    @Insert("INSERT INTO user(name, age, time) VALUES (#{name}, #{age}, #{time})")
    void insert(User user);
}
