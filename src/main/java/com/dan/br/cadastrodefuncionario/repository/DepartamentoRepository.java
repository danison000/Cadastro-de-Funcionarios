package com.dan.br.cadastrodefuncionario.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dan.br.cadastrodefuncionario.model.Departamento;


public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    Optional<Departamento> findById(Long id);

    Optional<Departamento> findByNome(String nome);
    

}
