package com.malikov.onlinelibrary.service;

import com.malikov.onlinelibrary.model.Book;
import com.malikov.onlinelibrary.model.Genre;
import com.malikov.onlinelibrary.repository.BookRepository;
import com.malikov.onlinelibrary.repository.GenreRepository;
import lombok.Getter;

public class GenreService extends BaseService<GenreRepository, Genre> {
    @Getter
    private static final GenreService instance = new GenreService();

    private GenreService() {
        super(GenreRepository.getInstance());
    }
}
