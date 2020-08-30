package com.sikiedu.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sikiedu.domain.User;
import com.sikiedu.service.UserService;

import java.util.UUID;

public class UserAction extends ActionSupport implements ModelDriven<User>{

    public User user= new User();

    public String register() throws Exception{

        user.setId(UUID.randomUUID().toString());

        UserService userService = new UserService();
        userService.Test();


        return "toLogin";
    }

    @Override
    public User getModel() {
        return user;
    }
}
