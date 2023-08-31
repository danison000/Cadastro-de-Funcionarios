package com.dan.br.cadastrodefuncionario.service;

import java.math.BigDecimal;
import java.util.List;


import com.dan.br.cadastrodefuncionario.model.Funcionario;

public interface FuncionarioService {

    void save(Funcionario funcionario);

    void update(Funcionario funcionario) throws Exception;

    void delete(Long id) throws Exception;

    Funcionario findById(Long id) throws Exception;

    List<Funcionario> findAll() throws Exception;

    List<Funcionario> findByName(String nome) throws Exception;

    List<Funcionario> findByDepartamento(Long id) throws Exception;

    List<Funcionario> findBySalario(BigDecimal salario1, BigDecimal salario2) throws Exception;

}
