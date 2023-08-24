package com.estudo.spring.model.entity;

import com.estudo.spring.model.enums.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks", schema = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    @Column(name = "date_create")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dateCreate;
    @Enumerated(value = EnumType.STRING)
    private StatusType status;

}

