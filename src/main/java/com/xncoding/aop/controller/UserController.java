package com.xncoding.aop.controller;

import com.xncoding.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xncoding.aop.aspect.UserAccess;

/**
 * Description:
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/first")
    public Object first() {
        return "first controller";
    }

    @RequestMapping("/doError")
    public Object error() {
        return 1 / 0;
    }

	@RequestMapping("/second")
    @UserAccess(desc = "second")
    public Object second() {
        return "second controller";
    }

    @GetMapping("/show")
    public String show() {
        return userService.show();
    }

    @GetMapping("/insert")
    public String insert(String name, int age) {


        return userService.insert(name, age);
    }

}
