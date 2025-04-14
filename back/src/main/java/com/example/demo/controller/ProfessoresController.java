package com.example.demo.controller;

import com.example.demo.entity.Professores;
import com.example.demo.service.ProfessoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/professores")
@CrossOrigin("*")
@RestController
public class ProfessoresController {

    @Autowired
    private ProfessoresService professoresService;

    @PostMapping
    public ResponseEntity<Professores> cadastrarProfessor(@RequestBody Professores professor) {
        Professores novoprofessor = professoresService.cadastrarProfessor(professor);
        return new ResponseEntity<>(novoprofessor, HttpStatus.CREATED);
    }
}

