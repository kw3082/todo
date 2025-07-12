package com.imoong.todo.domain;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class TodoModifier {

    private final TodoRepository todoRepository;
    private final TodoValidator todoValidator;
    private final TodoReader todoReader;

    public TodoModifier(TodoRepository todoRepository, TodoValidator todoValidator,
        TodoReader todoReader) {
        this.todoRepository = todoRepository;
        this.todoValidator = todoValidator;
        this.todoReader = todoReader;
    }

    @Transactional
    public void modifyTodo(User user, Long todoId, ModifyTodo modifyTodo) {
        todoValidator.validateOwner(user.id(), todoId);
        Todo todo = todoReader.readTodo(todoId);
        todo.modify(modifyTodo.content(), modifyTodo.status());
        todoRepository.modify(todo);
    }
}
