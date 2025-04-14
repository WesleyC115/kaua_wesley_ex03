package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Professores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long numeroTurma;
    private String nomeProfessor;
}
