package com.imoong.todo.domain;

 import com.imoong.todo.error.CoreErrorType;
import com.imoong.todo.error.CoreException;
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
        Todo todo = todoReader.readTodo(todoId);
        if (todo.isOwner(user.id())) {
            throw new CoreException(CoreErrorType.NOT_FOUND_DATA);
        }
        todo.modify(modifyTodo.content(), modifyTodo.status(), modifyTodo.priority());
        todoRepository.modify(todo);
    }
}
