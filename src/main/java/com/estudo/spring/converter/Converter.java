package com.estudo.spring.converter;

import com.estudo.spring.DTO.TaskDTO;
import com.estudo.spring.model.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class Converter {

    private final ModelMapper modelMapper = new ModelMapper();

    public TaskDTO convertToTaskDTO(Task task){
        return modelMapper.map(task, TaskDTO.class);
    }

    public Task convertToTask(TaskDTO dto){
        return modelMapper.map(dto, Task.class);
    }

}
