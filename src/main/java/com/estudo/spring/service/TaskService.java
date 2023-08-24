package com.estudo.spring.service;

import com.estudo.spring.DTO.TaskDTO;
import com.estudo.spring.converter.Converter;
import com.estudo.spring.model.entity.Task;
import com.estudo.spring.model.enums.StatusType;
import com.estudo.spring.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final Converter converter;

    public TaskService(TaskRepository repository, Converter converter){
        super();
        this.repository = repository;
        this.converter = converter;
    }

    public List<TaskDTO> getTask(){
        List<Task> tasks =  repository.findAll();
        return tasks.stream().map(converter::convertToTaskDTO).toList();
    }

    public ResponseEntity<TaskDTO> saveTask(TaskDTO dto){
        Task task = converter.convertToTask(dto);
        Task  taskSaved = repository.save(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convertToTaskDTO(taskSaved));
    }

    public ResponseEntity<String> editTask(TaskDTO dto){
        Objects.requireNonNull(dto.getId());

        Task task = repository.findById(dto.getId())
                .orElse(null);

        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found for ID: " + dto.getId());
        }

        BeanUtils.copyProperties(task, dto, "id");
        task.setStatus(dto.getStatus());
        Task newTask = repository.save(task);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

    public ResponseEntity<String> deleteTask(TaskDTO task){
        Objects.requireNonNull(task.getId());

        try {
            repository.deleteById(task.getId());
            return ResponseEntity.ok("Task deletada com sucesso");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found for Id: " + task.getId());
        }


}}
