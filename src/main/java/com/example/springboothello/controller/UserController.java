package com.example.springboothello.controller;

import com.example.springboothello.dao.UserDao;
import com.example.springboothello.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/user")
    public User add(){
        userDao.add(new User("1","heejung","1111"));
        return userDao.getById("1");
    }
}
