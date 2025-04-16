package com.example.demo.controller;

import com.example.demo.entity.Atividade;
import com.example.demo.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.DescriptorKey;
import java.util.List;

@RequestMapping("/atividades")
@CrossOrigin("*")
@RestController
public class AtividadeController {
    @Autowired
    private AtividadeService atividadeService;

    @PostMapping
    public ResponseEntity<Atividade> cadastrarAtividade(@RequestBody Atividade atividade) {
        Atividade novaAtividade = atividadeService.cadastrarAtividade(atividade);
        return new ResponseEntity<>(novaAtividade, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List> listarAtividades() {
        return ResponseEntity.ok((atividadeService.listarAtividades()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAtividade(@PathVariable Long id) {
        atividadeService.deletarAtividade(id);
        return ResponseEntity.noContent().build();
    }
}
