package com.imoong.todo.storage.db.core;

import com.imoong.todo.domain.Priority;
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

    @Enumerated(EnumType.STRING)
    private Priority priority;

    public TodoEntity(Long userId, String content, TodoStatus status, Priority priority) {
        this.userId = userId;
        this.content = content;
        this.status = status;
        this.priority = priority;
    }


    protected TodoEntity() {
    }

    public Todo toTodo() {
        return new Todo(
            this.getId(),
            this.userId,
            new DefaultDateTime(this.getCreatedAt(), this.getUpdatedAt()),
            this.status,
            this.content,
            this.priority);
    }

    public void modify(String content, TodoStatus status, Priority priority) {
        this.content = content;
        this.status = status;
        this.priority = priority;
    }


    public String getContent() {
        return content;
    }

    public Long getUserId() {
        return userId;
    }
}
