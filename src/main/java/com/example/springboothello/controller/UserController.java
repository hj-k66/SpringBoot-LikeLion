package com.example.springboothello.controller;

import com.example.springboothello.dao.UserDao;
import com.example.springboothello.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return "delete All users";
    }
    @DeleteMapping(value = "/users/{id}")
    public String deleteById(@PathVariable String id){
        userDao.getById(id)
    }
}
