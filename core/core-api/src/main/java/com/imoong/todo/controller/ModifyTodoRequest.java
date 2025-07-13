package com.imoong.todo.controller;

import com.imoong.todo.domain.ModifyTodo;
import com.imoong.todo.domain.Priority;
import com.imoong.todo.domain.TodoStatus;

public record ModifyTodoRequest(String content, TodoStatus status, Priority priority) {

    public ModifyTodo toModifyTodo() {
        return new ModifyTodo(content, status, priority);
    }

}
