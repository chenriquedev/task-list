package com.estudo.spring.DTO;

import com.estudo.spring.model.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private UUID id;
    private String title;
    private String description;
    @Builder.Default // Define valores padrão para campos não especificados no construtor
    private LocalDate dateCreate = LocalDate.now();

    @Builder.Default
    private StatusType status = StatusType.NOT_FINISHED;

}
