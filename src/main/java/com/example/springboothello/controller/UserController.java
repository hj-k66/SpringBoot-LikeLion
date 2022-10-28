package com.example.springboothello.controller;

import com.example.springboothello.dao.UserDao;
import com.example.springboothello.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @PostMapping(value = "/user")
    public User add(){
        userDao.add(new User("1","heejung","1111"));
        return userDao.getById("1");
    }

    @DeleteMapping(value = "/users")
    public String deleteAll(){
        userDao.deleteAll();
        return "delete All users"
    }
}
