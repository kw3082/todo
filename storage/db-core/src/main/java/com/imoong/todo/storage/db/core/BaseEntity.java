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
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "entityStatus")
  private EntityStatus entityStatus = EntityStatus.ACTIVE;

  @CreationTimestamp
  private LocalDateTime createdAt = LocalDateTime.MIN;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  protected BaseEntity() {}

  public BaseEntity(Long id) {
    this.id = id;
  }

  public void active() {
    this.entityStatus = EntityStatus.ACTIVE;
  }

  public void delete() {
    this.entityStatus = EntityStatus.DELETED;
  }

  public boolean isActive() {
    return this.entityStatus == EntityStatus.ACTIVE;
  }

  public boolean isDeleted() {
    return this.entityStatus == EntityStatus.DELETED;
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
