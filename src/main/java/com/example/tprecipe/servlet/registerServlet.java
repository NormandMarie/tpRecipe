package com.example.tprecipe.servlet;

import com.example.tprecipe.model.User;
import com.example.tprecipe.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(urlPatterns = "/register")
public class registerServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String photo = req.getParameter("photo");
        String password = req.getParameter("password");
        User user = userService.creatUser(nom, prenom, email, photo, password);
        HttpSession session = req.getSession();
        session.setAttribute("email", user.getEmail());
        resp.sendRedirect(req.getContextPath());
    }
}
