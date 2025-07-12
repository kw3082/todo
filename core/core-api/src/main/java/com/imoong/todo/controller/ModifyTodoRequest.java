package com.imoong.todo.controller;

import com.imoong.todo.domain.ModifyTodo;
import com.imoong.todo.domain.TodoStatus;

public record ModifyTodoRequest(String content, TodoStatus status) {

    public ModifyTodo toModifyTodo() {
        return new ModifyTodo(content, status);
    }

}
