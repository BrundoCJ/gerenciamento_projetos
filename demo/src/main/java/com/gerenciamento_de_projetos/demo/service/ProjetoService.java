package com.gerenciamento_de_projetos.demo.service;

import com.gerenciamento_de_projetos.demo.entity.Projeto;
import com.gerenciamento_de_projetos.demo.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> buscarPorId(Long id) {
        return projetoRepository.findById(id);
    }

    public boolean deletar(Long id) {
        if (projetoRepository.existsById(id)) {
            projetoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}