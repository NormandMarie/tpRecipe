package com.example.tprecipe.servlet;

import com.example.tprecipe.dao.UserDao;
import com.example.tprecipe.dto.UserDto;
import com.example.tprecipe.model.User;
import com.example.tprecipe.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(urlPatterns = "/secured/update")
public class updateUser  extends HttpServlet  {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        UserDto userDto = userService.findByEmail(email);
        req.setAttribute("userDto", userDto);
        req.getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email"); // Récupère l'email de l'URL
        System.out.println(email);
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String photo = req.getParameter("photo");
        userService.updateUser(nom, prenom, email, photo);
        resp.sendRedirect(req.getContextPath());
    }

}
