package com.imoong.todo.controller;

import com.imoong.todo.domain.ModifyTodo;
import com.imoong.todo.domain.ModifyTodoContent;

public record ModifyTodoContentRequest(String content) {

    public ModifyTodoContent toModifyTodoContent() {
        return new ModifyTodoContent(content);
    }

}
