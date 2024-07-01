package com.malikov.onlinelibrary.service;

import com.malikov.onlinelibrary.model.User;
import com.malikov.onlinelibrary.repository.UserRepository;
import lombok.Getter;

public class UserService extends BaseService<UserRepository, User> {
    @Getter
    private static final UserService instance = new UserService();

    private UserService() {
        super(UserRepository.getInstance());
    }
}
