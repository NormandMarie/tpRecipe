package com.example.tprecipe.service;

import com.example.tprecipe.dao.RecipeDao;
import com.example.tprecipe.dto.RecipeDto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class RecipeService {
    private static RecipeDao recipeDao = new RecipeDao();

    public static List<RecipeDto> getAllRecipes(){
        return recipeDao.getAllRecipes();
    }
    public static void addRecipe(String name, String type, int executionTime, String details, Date dateAdded, String photoUrl){
        recipeDao.addRecipe(name, type, executionTime, details, dateAdded, photoUrl);
    }

    public static List<RecipeDto> searchRecipesByKeyword(String keyword) {
        return recipeDao.searchRecipesByKeyword(keyword);
    }
    public static List<RecipeDto> getRecipesAddedSince(Date dateLimit){
        return recipeDao.getRecipesAddedSince(dateLimit);
    }
  public static RecipeDto randomRecipe(){
      Date currentDate = new Date();
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(currentDate);
      calendar.add(Calendar.DATE, -6);
      Date limitDate = calendar.getTime();

      List<RecipeDto> recipes = getRecipesAddedSince(limitDate);
      Random random = new Random();
      int randomIndex = random.nextInt(recipes.size());

      RecipeDto randomRecipe = recipes.get(randomIndex);
      return randomRecipe;
  }
}
