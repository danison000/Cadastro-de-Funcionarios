package com.dan.br.cadastrodefuncionario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dan.br.cadastrodefuncionario.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long>{

    @Query("SELECT c FROM Cargo c WHERE c.nome = :nome AND c.departamento.id = :departamentoId")
    Optional<Cargo> findByNomeInDepartamento(String nome, Long departamentoId);

    Optional<Cargo> findById(Long id);
    
}
