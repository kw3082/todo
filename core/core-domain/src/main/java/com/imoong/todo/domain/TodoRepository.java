package com.imoong.todo.domain;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    Todo save(User user, NewTodo newTodo);

    List<Todo> findByUser(User user);

    Optional<Todo> findById(Long id);

    boolean isOwner(Long userId, Long todoId);

    boolean existsTodo(Long todoId);

    void modify(Todo todo);

    void delete(Long todoId);
}
