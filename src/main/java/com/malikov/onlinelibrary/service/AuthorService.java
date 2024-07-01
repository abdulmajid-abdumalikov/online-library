package com.malikov.onlinelibrary.service;

import com.malikov.onlinelibrary.model.Author;
import com.malikov.onlinelibrary.model.Genre;
import com.malikov.onlinelibrary.repository.AuthorRepository;
import com.malikov.onlinelibrary.repository.GenreRepository;
import lombok.Getter;

public class AuthorService extends BaseService<AuthorRepository, Author> {
    @Getter
    private static final AuthorService instance = new AuthorService();

    private AuthorService() {
        super(AuthorRepository.getInstance());
    }
}
