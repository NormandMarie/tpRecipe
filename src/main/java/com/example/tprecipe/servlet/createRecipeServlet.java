package com.example.tprecipe.servlet;

import com.example.tprecipe.model.User;
import com.example.tprecipe.service.RecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/secured/createRecipe")
public class createRecipeServlet extends HttpServlet {
    RecipeService recipeService = new RecipeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addRecipe.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("name");
        String type = req.getParameter("type");
        int time = 0;
        if (req.getParameter("time") != null && !req.getParameter("time").isEmpty()) {
            time = Integer.parseInt(req.getParameter("time"));
        }
        String details = req.getParameter("details");
        String photo = req.getParameter("photo");
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        recipeService.addRecipe(nom, type, time, details, sqlDate, photo);
        resp.sendRedirect(req.getContextPath());

    }
}
