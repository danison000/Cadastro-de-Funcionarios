package com.dan.br.cadastrodefuncionario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dan.br.cadastrodefuncionario.model.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

    Optional<Funcionario> findById(Long id);

    @Query("SELECT f FROM Funcionario f WHERE  f.cargo.id = :id")
    Optional<List<Funcionario>> findByCargo(Long id);

    @Query("SELECT f FROM Funcionario f WHERE f.nome LIKE %:nome%")
    List<Funcionario> findByName(String nome);
    
}
