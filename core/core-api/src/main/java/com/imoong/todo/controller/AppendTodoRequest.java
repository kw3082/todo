package com.imoong.todo.controller;

import com.imoong.todo.domain.NewTodo;

public record AppendTodoRequest(String content){

    public NewTodo toNewTodo() {
        return new NewTodo(content);
    }
}
