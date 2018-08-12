package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.NotBlank;

/**
 * Created by 43799 on 2018/8/11.
 */
public class User {

    public interface UsersView{}

    public interface UserInfoView extends UsersView{}

    @NotBlank(message = "用户名不能为空")
    private String username;

    private String password;

    @JsonView(UsersView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserInfoView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
