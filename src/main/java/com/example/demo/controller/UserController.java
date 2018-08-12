package com.example.demo.controller;

import com.example.demo.bean.User;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 43799 on 2018/8/11.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping
    @JsonView(User.UsersView.class)
    public List<User> getUsers(){  //获取所有的用户
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUsername("大帅");
        user.setPassword("123456");
        users.add(user);
        User user1 = new User();
        user1.setUsername("dashuai");
        user1.setPassword("123456");
        users.add(user1);
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserInfoView.class)  //获取指定的用户
    public User getUser(@PathVariable Integer id){
//        throw new UserNotExistException(id);
//        throw new RuntimeException();
        System.out.println(id);
        User user = new User();
        user.setUsername("dashuai");
        user.setPassword("123456");
        return user;
    }

    @PostMapping
    public void create(@Valid @RequestBody User user,BindingResult errors){
        if(errors.hasErrors()){  //如果有校验错误信息,打印校验错误信息
            errors.getAllErrors().stream().forEach(
                    objectError -> {
                        FieldError fieldError = (FieldError)objectError;
                        System.out.print(objectError.getDefaultMessage());
                    });
        }
    }
}
