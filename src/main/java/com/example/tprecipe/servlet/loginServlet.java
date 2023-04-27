package com.example.tprecipe.servlet;



import com.example.tprecipe.dto.UserDto;
import com.example.tprecipe.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/login")
public class loginServlet extends HttpServlet {
    public UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            UserDto user = userService.findUser(email, password);
            if (user != null) {
                // Si les informations de connexion sont correctes, on stocke les données de l'utilisateur dans la session et on redirige vers la page d'accueil
                HttpSession session = req.getSession();
                session.setAttribute("email", user.getEmail());
                resp.sendRedirect(req.getContextPath());
            } else {
                // Si les informations de connexion sont incorrectes, on renvoie l'utilisateur vers la page de connexion avec un message d'erreur
                req.setAttribute("isError", true);
                req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
