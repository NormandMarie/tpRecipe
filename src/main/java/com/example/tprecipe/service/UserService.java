package com.example.tprecipe.service;

import com.example.tprecipe.dao.UserDao;
import com.example.tprecipe.dto.UserDto;
import com.example.tprecipe.model.User;

public class UserService {
    UserDao userDao = new UserDao();

    public UserDto findUser(String email, String password){
        return userDao.findUser(email,password);
    }
    public User creatUser(String nom, String prenom, String email, String photo, String password) {
        return userDao.creat(nom, prenom, email, photo, password);
    }

    public void updateUser(String nom, String prenom, String email, String photo){
         userDao.updateUser(nom,prenom,email,photo);
    }
    public UserDto findByEmail(String Email){
        return userDao.findByEmail(Email);
    }

}
