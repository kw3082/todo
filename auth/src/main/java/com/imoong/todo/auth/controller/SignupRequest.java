package com.imoong.todo.auth.controller;

import com.imoong.todo.auth.domain.NewAuthUser;
import org.springframework.security.crypto.password.PasswordEncoder;

public record SignupRequest(String username, String nickname, String password) {

  public NewAuthUser toNewAuthUser(PasswordEncoder passwordEncoder) {
    return new NewAuthUser(username, nickname, passwordEncoder.encode(password));
  }
}
