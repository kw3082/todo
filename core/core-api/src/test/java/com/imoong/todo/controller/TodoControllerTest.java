package com.imoong.todo.controller;


import static com.imoong.todo.test.api.RestDocsUtils.constraints;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import com.imoong.todo.domain.NewTodo;
import com.imoong.todo.domain.TodoService;
import com.imoong.todo.domain.User;
import com.imoong.todo.test.api.RestDocsTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.restdocs.payload.JsonFieldType;

class TodoControllerTest extends RestDocsTest {
    private TodoService todoService;

    private TodoController todoController;

    @BeforeEach
    public void setup() {
        todoService = mock(TodoService.class);
        todoController = new TodoController(todoService);
        mockMvc = mockController(todoController);
    }

    @Test
    public void append_todo_list_200() {
        when(todoService.appendTodo(any(User.class), any(NewTodo.class))).thenReturn(1L);

        given()
            .contentType(ContentType.JSON)
            .body(new AppendTodoRequest("투두 이름"))
            .post("/todos")
            .then()
            .log().all()
            .status(HttpStatus.OK)
            .apply(document(
                "appendTodo-todo",
                requestFields(
                    fieldWithPath("content").type(JsonFieldType.STRING).description("생성할 투두 리스트 이름")
                        .attributes(constraints("최대 20byte"))),
                responseFields(
                    fieldWithPath("result").type(JsonFieldType.STRING).description("성공 여부"),
                    fieldWithPath("data.id").type(JsonFieldType.NUMBER).description("생성된 투두리스트 식별자"))));
    }
}