package com.example.demo.controller;

import com.example.demo.entity.Atividade;
import com.example.demo.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AtividadeController {
    @Autowired
    private AtividadeService atividadeService;

    @PostMapping
    public ResponseEntity<Atividade> cadastrarTurma(@RequestBody Atividade atividade) {
        Atividade novaAtividade = atividadeService.cadastrarAtividade(atividade);
        return new ResponseEntity<>(novaAtividade, HttpStatus.CREATED);
    }
}
