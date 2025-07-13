package com.imoong.todo.domain;

import com.imoong.todo.support.DefaultDateTime;

public class Todo {

    private final Long id;
    private final Long userId;
    private String content;
    private TodoStatus status;
    private Priority priority;
    private final DefaultDateTime defaultDateTime;

    public void modifyContent(String content) {
        this.content = content;
    }

    public void modifyStatus(TodoStatus status) {
        this.status = status;
    }

    public Todo(Long id, Long userId, DefaultDateTime defaultDateTime, TodoStatus status,
        String content, Priority priority) {
        this.id = id;
        this.userId = userId;
        this.defaultDateTime = defaultDateTime;
        this.status = status;
        this.content = content;
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

    public Long getId() {
        return id;
    }

    public DefaultDateTime getDefaultDateTime() {
        return defaultDateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void modify(String content, TodoStatus status, Priority priority) {
        if (content != null) {
            this.content = content;
        }

        if (status != null) {
            this.status = status;
        }

        if (priority != null) {
            this.priority = priority;
        }
    }

    public boolean isOwner(Long userId) {
        return userId != null && this.userId != null && this.userId.equals(userId);
    }
}

