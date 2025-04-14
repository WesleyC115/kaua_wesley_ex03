package com.example.demo.controller;

import com.example.demo.entity.Turma;
import com.example.demo.service.TurmaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/turmas")
@CrossOrigin("*")
@RestController
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<Turma> cadastrarTurma(@RequestBody Turma turma) {
        Turma novaturma = turmaService.cadastrarTurma(turma);
        return new ResponseEntity<>(novaturma, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List> listarTurmas() {
        return ResponseEntity.ok((turmaService.listarTurmas()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Long id) {
        turmaService.deletarTurma(id);
        return ResponseEntity.noContent().build();
    }
}
