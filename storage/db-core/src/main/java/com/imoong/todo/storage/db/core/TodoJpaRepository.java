package com.imoong.todo.storage.db.core;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findByUserId(Long userId);

    boolean existsByUserIdAndId(Long userId, Long todoId);
}
