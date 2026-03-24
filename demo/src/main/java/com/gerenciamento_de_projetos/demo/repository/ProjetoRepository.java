package com.gerenciamento_de_projetos.demo.repository;

import com.gerenciamento_de_projetos.demo.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}