package com.imoong.todo.domain;

public record NewTodo(String content, TodoStatus status, Priority priority) {

    public NewTodo(String content) {
        this(content, TodoStatus.PENDING, Priority.MEDIUM);
    }
}
