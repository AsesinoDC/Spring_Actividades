package com.taller_2.events.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "event")
@Data
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate date_event;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer  capacity;
}
