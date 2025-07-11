package com.imoong.todo.domain;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TodoDeleter {

    private final TodoValidator todoValidator;
    private final TodoRepository todoRepository;
    private final TodoReader todoReader;

    public TodoDeleter(TodoValidator todoValidator, TodoRepository todoRepository,
        TodoReader todoReader) {
        this.todoValidator = todoValidator;
        this.todoRepository = todoRepository;
        this.todoReader = todoReader;
    }

    @Transactional
    public void deleteTodo(User user, Long todoId) {
        todoValidator.validateOwner(user.id(), todoId);
        todoRepository.delete(todoId);
    }

}
