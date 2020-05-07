package com.xncoding.common.service;

import com.xncoding.common.dao.UserDao;
import com.xncoding.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired //连接到UserDao Bean
    private UserDao userDao;

    public String show() {
        return "Hello World!";
    }

    public List<User> showDao(int age) {
        return userDao.get(age);
    }

    public String insert(String name, int age) { //插入一条记录
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setTime(new Date());
        userDao.insert(user);
        return "Insert ( \""+name+"\", age"+age+") OK!";
    }
}
