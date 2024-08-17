package com.taller_1.taller_crud.entitys;

import com.taller_1.taller_crud.enums.StatusTask;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "TASK")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 255, nullable = true)
    private String description;

    @Column(nullable = false)
    private LocalDate creation_date;

    @Column(nullable = false)
    private LocalTime creation_time;

    @Column(length = 50 ,nullable = true)
    private StatusTask status;

}
