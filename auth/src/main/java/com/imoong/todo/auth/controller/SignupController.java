package com.imoong.todo.auth.controller;

import com.imoong.todo.auth.domain.NewAuthUser;
import com.imoong.todo.auth.domain.SignupService;
import com.imoong.todo.auth.support.response.AuthApiResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

  private final PasswordEncoder passwordEncoder;
  private final SignupService signupService;

  public SignupController(PasswordEncoder passwordEncoder, SignupService signupService) {
    this.passwordEncoder = passwordEncoder;
    this.signupService = signupService;
  }

  @PostMapping("/signup")
  public AuthApiResponse<Void> signup(@RequestBody SignupRequest request) {
    NewAuthUser newAuthUser = request.toNewAuthUser(passwordEncoder);
    signupService.signup(newAuthUser);
    return AuthApiResponse.success();
  }
}
