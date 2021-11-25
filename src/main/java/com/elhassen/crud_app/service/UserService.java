package com.ouhamza.crud_app.service;

import com.ouhamza.crud_app.dao.UserReop;
import com.ouhamza.crud_app.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    

    @Autowired
    private UserReop userReop;

    public void saveUser(User user){
        userReop.save(user);
    }
}