package com.gerenciamento_de_projetos.demo.controller;

import com.gerenciamento_de_projetos.demo.entity.Projeto;
import com.gerenciamento_de_projetos.demo.service.ProjetoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
        Projeto projetoSalvo = projetoService.salvar(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> listarProjetos() {
        return ResponseEntity.ok(projetoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscarProjetoPorId(@PathVariable Long id) {
        Optional<Projeto> projeto = projetoService.buscarPorId(id);
        return projeto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id) {
        boolean deletado = projetoService.deletar(id);
        if (deletado) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}