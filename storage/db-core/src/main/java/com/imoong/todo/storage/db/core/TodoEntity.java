package com.imoong.todo.storage.db.core;

import com.imoong.todo.domain.Todo;
import com.imoong.todo.domain.TodoStatus;
import com.imoong.todo.support.DefaultDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class TodoEntity extends BaseEntity {

    private Long userId;
    private String content;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    public TodoEntity(Long userId, String content, TodoStatus status) {
        this.userId = userId;
        this.content = content;
        this.status = status;
    }


    protected TodoEntity() {
    }

    public Todo toTodo() {
        return new Todo(
            this.getId(),
            this.userId,
            new DefaultDateTime(this.getCreatedAt(), this.getUpdatedAt()),
            this.status,
            this.content);
    }

    public void modify(String content, TodoStatus status) {
        this.content = content;
        this.status = status;
    }


    public String getContent() {
        return content;
    }

    public Long getUserId() {
        return userId;
    }
}
