package com.imoong.todo.auth.domain;

public interface AuthUserRepository {

  void save(NewAuthUser newAuthUser);

  boolean existsByUsername(String username);

  boolean existsByNickname(String nickname);
}
