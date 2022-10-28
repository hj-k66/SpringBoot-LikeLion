package com.example.springboothello.controller;

import com.example.springboothello.dao.UserDao;
import com.example.springboothello.domain.User;
import com.example.springboothello.domain.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/user/{id}")
    public User getById(String id){
        return userDao.getById(id);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Integer> add(@RequestBody UserRequestDto userRequestDto){
        int result = userDao.add(new User(userRequestDto.getId(), userRequestDto.getName(), userRequestDto.getPassword()));
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping(value = "/user")
    public String deleteAll(){
        userDao.deleteAll();
        return "delete All users";
    }
    @DeleteMapping(value = "/user/{id}")
    public String deleteById(@PathVariable String id){
        userDao.deleteById(id);
        return String.format("delete user = %s", id);
    }
}
