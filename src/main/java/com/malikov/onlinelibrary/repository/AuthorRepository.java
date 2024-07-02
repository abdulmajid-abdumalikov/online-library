package com.malikov.onlinelibrary.repository;

import com.malikov.onlinelibrary.model.Author;
import lombok.Getter;

import java.util.List;

public class AuthorRepository implements BaseRepository<Author> {

    @Getter
    private static final AuthorRepository instance = new AuthorRepository();

    @Override
    public boolean save(Author model) {
        return false;
    }

    @Override
    public Author get(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Author> getAll() {
        return List.of();
    }

    @Override
    public boolean update(String id, Author model) {
        return false;
    }
}
