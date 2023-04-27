package com.example.tprecipe.service;

import com.example.tprecipe.dao.UserDao;
import com.example.tprecipe.dto.UserDto;

public class UserService {
    UserDao userDao = new UserDao();

    public UserDto findUser(String email, String password){
        return userDao.findUser(email,password);
    }
}
