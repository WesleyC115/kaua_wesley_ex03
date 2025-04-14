package com.example.demo.service;

import com.example.demo.entity.Atividade;
import com.example.demo.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {
    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Atividade> listarAtividades() {
        return atividadeRepository.findAll();
    }

    public Atividade cadastrarAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public Atividade buscarPorId(Long id) {
        return atividadeRepository.findById(id).orElse(null);
    }

    public void deletarAtividade(Long id) {
        atividadeRepository.deleteById(id);
    }
}