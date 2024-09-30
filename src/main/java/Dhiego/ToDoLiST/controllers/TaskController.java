package Dhiego.ToDoLiST.controllers;


import Dhiego.ToDoLiST.DTOS.TaskDTO;
import Dhiego.ToDoLiST.models.Task;
import Dhiego.ToDoLiST.repository.TaskRepository;
import Dhiego.ToDoLiST.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Task Controller", description = "Endpoints de manejamentos das task")
public class TaskController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TaskRepository repository;
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() throws Exception {
        return ResponseEntity.ok(taskService.findAll());
    }

    public ResponseEntity<Task> createTask(@RequestBody TaskDTO task) throws Exception {
        Task newTask = new Task(task);
        taskService.save(newTask);
        return ResponseEntity.ok().body(newTask);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable long id) throws Exception {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskDTO task) throws Exception {
        Task newTask = new Task(task);
        taskService.delete(id);
        taskService.save(newTask);
        return ResponseEntity.ok().body(newTask);
    }

}
