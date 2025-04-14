package com.example.demo.service;

import com.example.demo.entity.Turma;
import com.example.demo.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> listarTurmas() {
        return turmaRepository.findAll();
    }

    public Turma cadastrarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma buscarPorId(Long id) {
        return turmaRepository.findById(id).orElse(null);
    }

    public void deletarTurma(Long id) {
        turmaRepository.deleteById(id);
    }
}