package com.taller_1.taller_crud.controllers;

import com.taller_1.taller_crud.entitys.TaskEntity;
import com.taller_1.taller_crud.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/readAll")
    public String getAllTasks(Model model) {
        List<TaskEntity> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "pages/readAll";
    }

    @GetMapping("/readOne/{id}")
    public String getTaskById(@PathVariable Integer id, Model model) {
        Optional<TaskEntity> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return "pages/readOne";
        } else {
            return "redirect:/tasks/readAll";
        }
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new TaskEntity());
        return "pages/create";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute TaskEntity task) {
        taskService.createTask(task);
        return "redirect:/tasks/readAll";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Optional<TaskEntity> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return "pages/update";
        } else {
            return "pages/readAll";
        }
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Integer id, @ModelAttribute TaskEntity task) {
        task.setId(id);
        taskService.updateTask(id, task);
        return "redirect:/tasks/readAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return "redirect:/tasks/readAll";
    }
}
