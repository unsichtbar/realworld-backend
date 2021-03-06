package com.example.application.domain.ports.out;

import com.example.application.domain.model.User;
import java.util.Optional;

public interface GetUserPort {
  Optional<User> getUserByUsername(String username);

  Optional<User> getUserByEmail(String email);

  Optional<User> getUserById(Integer userId);
}
