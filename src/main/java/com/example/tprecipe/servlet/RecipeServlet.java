package com.example.tprecipe.servlet;

import com.example.tprecipe.dto.RecipeDto;
import com.example.tprecipe.service.RecipeService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/recipes")
public class RecipeServlet extends HttpServlet {
    RecipeService recipeService = new RecipeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RecipeDto> recipeDtos = recipeService.getAllRecipes();
        System.out.println(recipeDtos);
        req.setAttribute("recipeDtos", recipeDtos);
        RequestDispatcher viewpost = req.getRequestDispatcher("/WEB-INF/recipes.jsp");
        viewpost.forward(req, resp);
    }
}
