package com.imoong.todo.controller;

import com.imoong.todo.domain.Todo;
import java.time.LocalDateTime;
import java.util.List;

public record TodoResponse(
    Long id, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {

    public static List<TodoResponse> of(List<Todo> todos) {
        return todos.stream()
            .map(todo -> new TodoResponse(
                todo.getId(),
                todo.getContent(),
                todo.getDefaultDateTime().createdAt(),
                todo.getDefaultDateTime().updatedAt()))
            .toList();
    }

}
