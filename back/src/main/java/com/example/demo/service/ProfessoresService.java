package com.example.demo.service;

import com.example.demo.entity.Professores;
import com.example.demo.repository.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessoresService {

    @Autowired
    private ProfessoresRepository professoresRepository;

    public List<Professores> listarProfessores() {
        return professoresRepository.findAll();
    }

    public Professores cadastrarProfessor(Professores professor) {
        return professoresRepository.save(professor);
    }

    public Professores buscarPorId(Long id) {
        return professoresRepository.findById(id).orElse(null);
    }

    public void deletarProfessor(Long id) {
        professoresRepository.deleteById(id);
    }
}