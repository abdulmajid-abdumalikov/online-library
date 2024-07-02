package com.malikov.onlinelibrary.service;

import com.malikov.onlinelibrary.model.Book;
import com.malikov.onlinelibrary.model.User;
import com.malikov.onlinelibrary.repository.BookRepository;
import com.malikov.onlinelibrary.repository.UserRepository;
import lombok.Getter;

import java.util.List;

public class BookService extends BaseService<BookRepository, Book> {
    @Getter
    private static final BookService instance = new BookService();

    private BookService() {
        super(BookRepository.getInstance());
    }

    @Override
    public List<Book> getAll() {
        return super.getAll();
    }
}
