package com.imoong.todo.domain;

import com.imoong.todo.error.CoreErrorType;
import com.imoong.todo.error.CoreException;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private final TodoRepository todoRepository;

    public TodoValidator(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    void validateTodoId(Long todoId) {
        if (!todoRepository.existsTodo(todoId)) {
            throw new CoreException(CoreErrorType.NOT_FOUND_DATA, todoId);
        }
    }

    void validateOwner(Long userId, Long todoId) {
        if (!todoRepository.isOwner(userId, todoId)) {
            throw new CoreException(CoreErrorType.NOT_FOUND_DATA, todoId);
        }
    }

}
