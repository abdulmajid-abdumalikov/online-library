package com.malikov.onlinelibrary.repository;

import com.malikov.onlinelibrary.model.Book;
import lombok.Getter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements BaseRepository<Book> {

    @Getter
    private static final BookRepository instance = new BookRepository();

    @Override
    public boolean save(Book model) {
        return false;
    }

    @Override
    public Book get(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Book> getAll() {
        PreparedStatement preparedStatement = null;
        List<Book> books;
        try {
            preparedStatement = connection.prepareStatement("select * from books;");
            ResultSet resultSet = preparedStatement.executeQuery();
            books = new ArrayList<>();
            while (resultSet.next()) {
                Book course = Book.map(resultSet);
                books.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public boolean update(String id, Book model) {
        return false;
    }
}
