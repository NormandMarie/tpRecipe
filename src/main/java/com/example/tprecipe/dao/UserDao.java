package com.example.tprecipe.dao;

import com.example.tprecipe.dto.UserDto;
import com.example.tprecipe.model.User;
import com.example.tprecipe.service.DDBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public UserDto findUser(String email, String password) {
        String requeteSQl = "SELECT email, password FROM user WHERE email = ? AND password = ?";
        Connection connection = DDBconnect.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(requeteSQl)) {

            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String userEmail = result.getString("email");
                String userPassword = result.getString("password");
                return new UserDto(userEmail, userPassword);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User creat(String nom, String prenom, String email, String photo, String password) {
        final String INSERT_SQL = "INSERT INTO user (nom,prenom,email,photo, password) VALUES (?,?,?,?,?)";
        User user = null;
        Connection connection = DDBconnect.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {

            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, email);
            statement.setString(4, photo);
            statement.setString(5, password);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                user = new User(nom, prenom, email, photo, password);
                System.out.println(user.getFirstname() + " a bien été cée");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public UserDto findByEmail(String email) {

        String requeteSQl = "SELECT nom,prenom,photo,email FROM user WHERE email = ?";
        Connection connection = DDBconnect.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(requeteSQl)) {
            statement.setString(1, email);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String photo = result.getString("photo");
                System.out.println(nom);
                System.out.println(prenom);
                System.out.println(email);
                System.out.println(photo);
                return  new UserDto(nom,prenom,email,photo);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(String nom, String prenom, String email, String photo) {
        final String UPDATE_SQL = "UPDATE user SET nom=?, prenom=?, photo=? WHERE email=?";

        Connection connection = DDBconnect.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, photo);
            statement.setString(4, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
