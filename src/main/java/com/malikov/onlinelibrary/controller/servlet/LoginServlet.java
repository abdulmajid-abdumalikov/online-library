package com.malikov.onlinelibrary.controller.servlet;

import com.malikov.onlinelibrary.model.Book;
import com.malikov.onlinelibrary.model.User;
import com.malikov.onlinelibrary.service.BookService;
import com.malikov.onlinelibrary.service.UserService;
import com.malikov.onlinelibrary.utils.Beans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/", "/login"})
public class LoginServlet extends HttpServlet {

    private final UserService userService = Beans.userService;
    private final BookService bookService = Beans.bookService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User login = userService.login(username, password);

        if (login != null) {
            req.getSession().setAttribute("user", login);
            List<Book> books = bookService.getAll();
            req.setAttribute("books", books);
            req.getRequestDispatcher("home.jsp").forward(req, resp);

        } else {
            req.setAttribute("errorMessage", "Invalid username or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
