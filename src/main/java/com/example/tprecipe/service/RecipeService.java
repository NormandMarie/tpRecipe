package com.example.tprecipe.service;

import com.example.tprecipe.dao.RecipeDao;
import com.example.tprecipe.dto.RecipeDto;

import java.util.List;

public class RecipeService {
    private static RecipeDao recipeDao = new RecipeDao();

    public static List<RecipeDto> getAllRecipes(){
        return recipeDao.getAllRecipes();
    }
}
