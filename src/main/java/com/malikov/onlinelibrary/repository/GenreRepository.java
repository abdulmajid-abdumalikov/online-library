package com.malikov.onlinelibrary.repository;

import com.malikov.onlinelibrary.model.Genre;
import lombok.Getter;

import java.util.List;

public class GenreRepository implements BaseRepository<Genre>{

    @Getter
    private static final GenreRepository instance = new GenreRepository();

    @Override
    public boolean save(Genre model) {
return false;
    }

    @Override
    public Genre get(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Genre> getAll() {
        return List.of();
    }

    @Override
    public boolean update(String id, Genre model) {
        return false;
    }
}
