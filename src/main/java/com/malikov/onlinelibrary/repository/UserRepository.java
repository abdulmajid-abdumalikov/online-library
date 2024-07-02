package com.malikov.onlinelibrary.repository;

import com.malikov.onlinelibrary.model.User;
import lombok.Getter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository implements BaseRepository<User> {

    @Getter
    private static final UserRepository instance = new UserRepository();

    @Override
    public boolean save(User model) {
        String save = "insert into users (name, username, password, email, phone_number) values (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(save);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getUsername());
            preparedStatement.setString(3, model.getPassword());
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setString(5, model.getPhone());
            int i = preparedStatement.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    public User login(String username, String password){
        String login = "select * from users where username =? and password =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(login);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return User.map(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
