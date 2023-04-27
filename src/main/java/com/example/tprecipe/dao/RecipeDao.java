package com.example.tprecipe.dao;

import com.example.tprecipe.dto.RecipeDto;
import com.example.tprecipe.service.DDBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao {
    public List<RecipeDto> getAllRecipes() {
        List<RecipeDto> recipeDtos = new ArrayList<>();
        String query = "SELECT * FROM recipe";
        Connection connection = DDBconnect.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                RecipeDto recipeDto = new RecipeDto(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getInt("execution_time"),
                        resultSet.getString("details"),
                        resultSet.getDate("date_added"),
                        resultSet.getString("photo_url")
                );
                recipeDtos.add(recipeDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recipeDtos;

    }
}