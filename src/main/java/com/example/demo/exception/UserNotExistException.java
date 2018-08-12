package com.example.demo.exception;

/**
 * Created by 43799 on 2018/8/12.
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException(Integer userId){
        super("用户不存在");
        this.userId = userId;
    }

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
