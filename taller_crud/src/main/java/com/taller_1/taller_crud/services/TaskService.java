package com.taller_1.taller_crud.services;

import com.taller_1.taller_crud.entitys.TaskEntity;
import com.taller_1.taller_crud.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity createTask(TaskEntity taskEntity){
        return taskRepository.save(taskEntity);
    }

    public List<TaskEntity> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> getTaskById(Integer id){
        return taskRepository.findById(id);
    }

    public Optional<TaskEntity> getTaskByTitle(String title){
        return taskRepository.findByTitle(title);
    }

    public TaskEntity updateTask(Integer id, TaskEntity task){
        if(!taskRepository.existsById(id)){
            throw new IllegalArgumentException("La tarea con el id " + id + " no existe.");
        }
        task.setId(id);
        return taskRepository.save(task);
    }

    public void deleteTask(Integer id){
        if(!taskRepository.existsById(id)){
            throw new IllegalArgumentException("La tarea con el id " + id + " no existe.");
        }
        taskRepository.deleteById(id);
    }

}
