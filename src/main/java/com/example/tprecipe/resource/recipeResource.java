package com.example.tprecipe.resource;

import com.example.tprecipe.dto.RecipeDto;
import com.example.tprecipe.service.RecipeService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;
import java.util.List;

@Path("/recipes")
public class recipeResource {
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<RecipeDto> getAllRecipes() throws SQLException {

        List<RecipeDto> recipeDtos = RecipeService.getAllRecipes();
        System.out.println(recipeDtos);
        return recipeDtos;
    }
    @GET
    @Path("/{keyword}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RecipeDto> getRecipeWithKeyword(@PathParam("keyword") String keyword) {
        List<RecipeDto> recipeDtos = RecipeService.searchRecipesByKeyword(keyword);
        return recipeDtos;
    }
    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public   RecipeDto getRandomRecipe() {
        RecipeDto recipeDtos = RecipeService.randomRecipe();
        return recipeDtos;
    }
}
