package com.imoong.todo.domain;

import org.springframework.stereotype.Component;

@Component
public class TodoAppender {

    private final TodoRepository todoRepository;

    public TodoAppender(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo appendTodo(User user, NewTodo newTodo) {
        return todoRepository.save(user, newTodo);
    }
}
