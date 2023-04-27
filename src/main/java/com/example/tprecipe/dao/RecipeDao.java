package com.example.tprecipe.dao;

import com.example.tprecipe.dto.RecipeDto;
import com.example.tprecipe.model.Recipe;
import com.example.tprecipe.service.DDBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
    public void addRecipe(String name, String type, int executionTime, String details, Date dateAdded, String photoUrl) {
        final String INSERT_SQL = "INSERT INTO recipe (name, type, execution_time, details, date_added, photo_url) VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = DDBconnect.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setInt(3, executionTime);
            statement.setString(4, details);
            statement.setDate(5, new java.sql.Date(dateAdded.getTime()));
            statement.setString(6, photoUrl);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<RecipeDto> searchRecipesByKeyword(String keyword) {
        List<RecipeDto> recipes = new ArrayList<>();
        final String SELECT_SQL = "SELECT * FROM recipe WHERE name LIKE ? OR details LIKE ? OR type LIKE ?";
        Connection connection = DDBconnect.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                int executionTime = resultSet.getInt("execution_time");
                String details = resultSet.getString("details");
                Date dateAdded = resultSet.getDate("date_added");
                String photoUrl = resultSet.getString("photo_url");
                RecipeDto recipe = new RecipeDto(id, name, type, executionTime, details, dateAdded, photoUrl);
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

}
