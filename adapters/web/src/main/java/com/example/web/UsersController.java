package com.example.web;

import com.example.UserService;
import com.example.exceptions.EmailAreadyTakenException;
import com.example.exceptions.UsernameAlreadyTakenException;
import com.example.web.dto.UserLogin;
import com.example.web.dto.UserRegistration;
import com.example.web.dto.UserResponse;
import com.example.web.dto.UserWebMapper;
import javax.security.auth.login.LoginException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

  private UserService userService;
  private UserWebMapper userMapper;

  @PostMapping
  public ResponseEntity<UserResponse> createUser(@RequestBody UserRegistration body) {
    try {

      return ResponseEntity.ok(
          userMapper.mapUserToResponse(
              this.userService.register(
                  body.getUser().getUsername(),
                  body.getUser().getEmail(),
                  body.getUser().getPassword())));
    } catch (EmailAreadyTakenException | UsernameAlreadyTakenException e) {
      return ResponseEntity.status(204).build();
    }
  }

  @PostMapping("/login")
  public ResponseEntity<UserResponse> login(@RequestBody UserLogin body) {
    try {
      return ResponseEntity.ok()
          .body(
              userMapper.mapUserToResponse(
                  this.userService.login(body.getUser().getEmail(), body.getUser().getPassword())));
    } catch (LoginException e) {
      return ResponseEntity.status(401).build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
