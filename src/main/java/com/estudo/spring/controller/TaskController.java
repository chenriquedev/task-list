package com.estudo.spring.controller;

import com.estudo.spring.DTO.TaskDTO;
import com.estudo.spring.converter.Converter;
import com.estudo.spring.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskDTO>> getAll(){
        List<TaskDTO> tasks = service.getTask();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/newTask")
    public ResponseEntity<TaskDTO> save(@RequestBody TaskDTO dto){
        return service.saveTask(dto);
    }

    @PutMapping("/editTask")
    public ResponseEntity<String> edit(@RequestBody TaskDTO task){
        return service.editTask(task);
    }

    @DeleteMapping("/deleteTask")
    public ResponseEntity<String> deletar(@RequestBody TaskDTO dto){
       return service.deleteTask(dto);
    }
}
