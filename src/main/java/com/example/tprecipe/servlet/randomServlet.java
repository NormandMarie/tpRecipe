package com.example.tprecipe.servlet;

import com.example.tprecipe.dto.RecipeDto;
import com.example.tprecipe.service.RecipeService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/secured/random")
public class randomServlet extends HttpServlet {
    RecipeService recipeService = new RecipeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeDto recipe = recipeService.randomRecipe();
        System.out.println(recipe);
        req.setAttribute("recipe", recipe);


        RequestDispatcher viewpost = req.getRequestDispatcher("/WEB-INF/randomRecipe.jsp");
        viewpost.forward(req, resp);
    }
}
