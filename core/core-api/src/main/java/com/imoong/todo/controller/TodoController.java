package com.imoong.todo.controller;

import com.imoong.todo.domain.NewTodo;
import com.imoong.todo.domain.Todo;
import com.imoong.todo.domain.TodoService;
import com.imoong.todo.domain.User;
import com.imoong.todo.support.response.ApiResponse;
import com.imoong.todo.support.response.DefaultIdResponse;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    public final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todos")
    public ApiResponse<DefaultIdResponse> append(
        ApiUser apiUser, @RequestBody AppendTodoRequest request) {
        NewTodo newTodo = request.toNewTodo();
        User user = apiUser.toUser();
        Long id = todoService.appendTodo(user, newTodo);
        return ApiResponse.success(new DefaultIdResponse(id));
    }

    @GetMapping("/todos")
    public ApiResponse<List<TodoResponse>> readTodos(ApiUser apiUser) {
        User user = apiUser.toUser();
        List<Todo> todos = todoService.readTodos(user);
        return ApiResponse.success(TodoResponse.of(todos));
    }

    @PatchMapping("/todos/{todoId}")
    public ApiResponse<Void> modify(ApiUser apiUser, @PathVariable Long todoId,
        @RequestBody ModifyTodoRequest request) {
        todoService.modifyTodo(apiUser.toUser(), todoId, request.toModifyTodo());
        return ApiResponse.success();
    }

    @DeleteMapping("/todos/{todoId}")
    public ApiResponse<Void> delete(ApiUser apiUser, @PathVariable Long todoId) {
        todoService.deleteTodo(apiUser.toUser(), todoId);
        return ApiResponse.success();
    }
}
