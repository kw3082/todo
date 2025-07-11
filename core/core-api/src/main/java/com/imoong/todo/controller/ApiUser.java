package com.imoong.todo.controller;

import com.imoong.todo.domain.User;

public record ApiUser(Long id) {

  public User toUser() {
    return new User(id);
  }
}
