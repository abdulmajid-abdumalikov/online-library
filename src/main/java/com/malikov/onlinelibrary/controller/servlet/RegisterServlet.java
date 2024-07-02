package com.malikov.onlinelibrary.controller.servlet;


import com.malikov.onlinelibrary.model.User;
import com.malikov.onlinelibrary.service.UserService;
import com.malikov.onlinelibrary.utils.Beans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final UserService userService = Beans.userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phoneNumber");

        if (userService.save(User
                .builder()
                .name(name)
                .username(username)
                .password(password)
                .email(email)
                .phone(phone)
                .build())) {
            resp.sendRedirect("/home");
        } else {
            resp.sendRedirect("register.jsp");
        }
    }
}
