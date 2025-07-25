package com.imoong.todo.storage.db.core;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class AuthBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "entityStatus")
  private AuthEntityStatus entityStatus = AuthEntityStatus.ACTIVE;

  @CreationTimestamp
  private LocalDateTime createdAt = LocalDateTime.MIN;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  protected AuthBaseEntity() {}

  public void active() {
    this.entityStatus = AuthEntityStatus.ACTIVE;
  }

  public void delete() {
    this.entityStatus = AuthEntityStatus.DELETED;
  }

  public boolean isActive() {
    return this.entityStatus == AuthEntityStatus.ACTIVE;
  }

  public boolean isDeleted() {
    return this.entityStatus == AuthEntityStatus.DELETED;
  }

  public Long getId() {
    return id;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }
}
