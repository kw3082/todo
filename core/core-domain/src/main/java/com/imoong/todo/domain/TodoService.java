package com.imoong.todo.domain;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoAppender todoAppender;
    private final TodoReader todoReader;
    private final TodoModifier todoModifier;
    private final TodoDeleter todoDeleter;

    public TodoService(TodoAppender todoAppender, TodoReader todoReader,
        TodoModifier todoModifier,
        TodoDeleter todoDeleter) {
        this.todoAppender = todoAppender;
        this.todoReader = todoReader;
        this.todoModifier = todoModifier;
        this.todoDeleter = todoDeleter;
    }

    public Long appendTodo(User user, NewTodo newTodo) {
        Todo todo = todoAppender.appendTodo(user, newTodo);
        return todo.getId();
    }

    public List<Todo> readTodos(User user) {
        return todoReader.readTodos(user);
    }

    public void modifyTodo(User user, ModifyTodo modifyTodo) {
        todoModifier.modifyTodo(user, modifyTodo);
    }

    public void deleteTodo(User user, Long todoId) {
        todoDeleter.deleteTodo(user, todoId);
    }
}
