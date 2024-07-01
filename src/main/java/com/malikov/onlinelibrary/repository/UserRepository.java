package com.malikov.onlinelibrary.repository;

import com.malikov.onlinelibrary.model.User;
import lombok.Getter;

import java.util.List;

public class UserRepository implements BaseRepository<User>{

    @Getter
    private static final UserRepository instance = new UserRepository();

    @Override
    public void save(User model) {

    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public boolean update(String id, User model) {
        return false;
    }
}
