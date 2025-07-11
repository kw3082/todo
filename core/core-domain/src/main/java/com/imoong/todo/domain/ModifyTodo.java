package com.imoong.todo.domain;

public record ModifyTodo(Long todoId, String content, TodoStatus status) {

}
