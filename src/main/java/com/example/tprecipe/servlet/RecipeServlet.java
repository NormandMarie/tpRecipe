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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/recipes")
public class RecipeServlet extends HttpServlet {
    RecipeService recipeService = new RecipeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RecipeDto> recipeDtos = recipeService.getAllRecipes();
        System.out.println(recipeDtos);
        req.setAttribute("recipeDtos", recipeDtos);
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        req.setAttribute("email", email);

        RequestDispatcher viewpost = req.getRequestDispatcher("/WEB-INF/recipes.jsp");
        viewpost.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
        String dateStr = formatter.format(date);

        try {
            recipeService.addRecipe("Ma recette", "Plat principal", 60, "Lorem ipsum dolor sit amet", formatter.parse(dateStr), "https://example.com/my_recipe.jpg");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath());
    }
}

