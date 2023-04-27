package com.example.tprecipe.service;

import com.example.tprecipe.dao.RecipeDao;
import com.example.tprecipe.dto.RecipeDto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecipeService {
    private static RecipeDao recipeDao = new RecipeDao();

    public static List<RecipeDto> getAllRecipes(){
        return recipeDao.getAllRecipes();
    }
    public static void addRecipe(String name, String type, int executionTime, String details, Date dateAdded, String photoUrl){
        recipeDao.addRecipe(name, type, executionTime, details, dateAdded, photoUrl);
    }

}
