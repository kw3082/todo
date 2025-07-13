package com.imoong.todo.storage.db.core;

import com.imoong.todo.domain.NewTodo;
import com.imoong.todo.domain.Todo;
import com.imoong.todo.domain.TodoRepository;
import com.imoong.todo.domain.User;
import com.imoong.todo.error.CoreErrorType;
import com.imoong.todo.error.CoreException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class TodoCoreRepository implements TodoRepository {

    private final TodoJpaRepository todoJpaRepository;

    public TodoCoreRepository(TodoJpaRepository todoJpaRepository) {
        this.todoJpaRepository = todoJpaRepository;
    }

    @Override
    public boolean existsTodo(Long todoId) {
        return todoJpaRepository.existsById(todoId);
    }

    @Override
    public void modify(Todo todo) {
        TodoEntity todoEntity = todoJpaRepository.findById(todo.getId()).orElseThrow(
            () -> new CoreException(CoreErrorType.NOT_FOUND_DATA, todo.getId())
        );
        todoEntity.modify(todo.getContent(), todo.getStatus(), todo.getPriority());
    }

    @Override
    public void delete(Long todoId) {
        TodoEntity todoEntity = todoJpaRepository.findById(todoId)
            .orElseThrow(() -> new CoreException(CoreErrorType.NOT_FOUND_DATA, todoId));
        todoEntity.delete();
    }


    @Override
    public Todo save(User user, NewTodo newTodo) {
        return todoJpaRepository.save(
            new TodoEntity(user.id(), newTodo.content(), newTodo.status(), newTodo.priority())).toTodo();
    }

    @Override
    public List<Todo> findByUser(User user) {
        return todoJpaRepository.findByUserId(user.id())
            .stream().map(TodoEntity::toTodo).toList();
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return todoJpaRepository.findById(id)
            .map(TodoEntity::toTodo);
    }

    @Override
    public boolean isOwner(Long userId, Long todoId) {
        return todoJpaRepository.existsByUserIdAndId(userId, todoId);
    }
}
