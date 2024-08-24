package com.taller_2.events.repositories.interfaces;

import com.taller_2.events.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, String> {
}
