package com.malikov.onlinelibrary.repository;

import com.malikov.onlinelibrary.model.Book;
import lombok.Getter;

import java.util.List;

public class BookRepository implements BaseRepository<Book>{

    @Getter
    private static final BookRepository instance = new BookRepository();

    @Override
    public void save(Book model) {

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
        return List.of();
    }

    @Override
    public boolean update(String id, Book model) {
        return false;
    }
}
