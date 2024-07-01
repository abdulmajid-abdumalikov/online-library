package com.malikov.onlinelibrary.utils;

import com.malikov.onlinelibrary.service.AuthorService;
import com.malikov.onlinelibrary.service.BookService;
import com.malikov.onlinelibrary.service.GenreService;
import com.malikov.onlinelibrary.service.UserService;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Beans {

    public static final UserService userService = UserService.getInstance();
    public static final BookService studentService = BookService.getInstance();
    public static final AuthorService groupService = AuthorService.getInstance();
    public static final GenreService courseService = GenreService.getInstance();

    @Getter
    private static final Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/online-library",
                    "postgres",
                    "0800"
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
