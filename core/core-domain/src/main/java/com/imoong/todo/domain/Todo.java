    package com.imoong.todo.domain;

    import com.imoong.todo.support.DefaultDateTime;

    public class Todo {

        private final Long id;
        private final Long userId;
        private String content;
        private TodoStatus status;
        private final DefaultDateTime defaultDateTime;

        public void modifyContent(String content) {
            this.content = content;
        }

        public void modifyStatus(TodoStatus status) {
            this.status = status;
        }

        public Todo(Long id, Long userId, DefaultDateTime defaultDateTime, TodoStatus status,
            String content) {
            this.id = id;
            this.userId = userId;
            this.defaultDateTime = defaultDateTime;
            this.status = status;
            this.content = content;
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

        public void modify(String content, TodoStatus status) {
            if (content != null) {
                this.content = content;
            }

            if (status != null) {
                this.status = status;
            }
        }
    }

