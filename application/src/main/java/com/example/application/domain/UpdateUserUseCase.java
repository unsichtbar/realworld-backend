package com.example.application.domain;

import com.example.application.domain.model.User;

public interface UpdateUserUseCase {
    User updateUser(String username, User user);
}
