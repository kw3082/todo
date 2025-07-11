package com.imoong.todo.domain;

import com.imoong.todo.error.CoreErrorType;
import com.imoong.todo.error.CoreException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TodoReader {
    private final TodoRepository todoRepository;

    public TodoReader(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    List<Todo> readTodos(User user) {
        return todoRepository.findByUser(user);
    }

    Todo readTodo(Long todoId) {
        return todoRepository.findById(todoId)
            .orElseThrow(() -> new CoreException(CoreErrorType.NOT_FOUND_DATA, todoId));
    }
}
