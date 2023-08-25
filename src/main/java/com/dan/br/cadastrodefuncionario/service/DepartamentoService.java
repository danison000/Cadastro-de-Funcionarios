package com.dan.br.cadastrodefuncionario.service;

import java.util.List;


import com.dan.br.cadastrodefuncionario.model.Departamento;

public interface DepartamentoService {

    void save(Departamento departamento) throws Exception;

    void update(Departamento departamento) throws Exception;

    void delete(Long id) throws Exception;

    Departamento findById(Long id) throws Exception;

    List<Departamento> findAll() throws Exception;

}
