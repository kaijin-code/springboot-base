package com.xncoding.common.service;

import com.xncoding.common.dao.UserDao;
import com.xncoding.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public String insert(String name, int age) { //插入一条记录
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setTime(new Date());
        update(name, age);
        delete(3);

        //int e = 1/0;
        userDao.insert(user);
        return "Insert ( \""+name+"\", age"+age+") OK!";
    }

    @Transactional
    public int update(String name, int age){
        User user = new User();
        user.setId(1);
        user.setName(name);
        user.setAge(age);
        return userDao.update(user);
    }

    public int delete(int id){
        return userDao.deleteById(id);
    }
}
