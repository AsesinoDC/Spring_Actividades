package com.taller_1.taller_crud.repository;

import com.taller_1.taller_crud.entitys.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    Optional<TaskEntity> findByTitle(String title);
}
