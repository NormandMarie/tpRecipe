package com.example.tprecipe.dao;

import com.example.tprecipe.dto.UserDto;
import com.example.tprecipe.model.User;
import com.example.tprecipe.service.DDBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public UserDto findUser(String email, String password){
        String requeteSQl = "SELECT email, password FROM user WHERE email = ? AND password = ?";
        Connection connection = DDBconnect.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(requeteSQl)) {

            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String userEmail = result.getString("email");
                String userPassword = result.getString("password");
                return new UserDto(userEmail,userPassword);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
