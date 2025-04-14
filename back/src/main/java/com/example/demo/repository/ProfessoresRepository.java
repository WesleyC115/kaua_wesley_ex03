package com.example.demo.repository;

import com.example.demo.entity.Professores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessoresRepository extends JpaRepository<Professores, Long> {
}