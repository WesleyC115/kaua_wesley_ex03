package com.example.demo.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Turma {
    private Long numeroTurma;
    private String nomeTurma;
    
}
