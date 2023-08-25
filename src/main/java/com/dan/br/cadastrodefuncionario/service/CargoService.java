package com.dan.br.cadastrodefuncionario.service;

import java.util.List;

import com.dan.br.cadastrodefuncionario.model.Cargo;

public interface CargoService {

    void save(Cargo objT) throws Exception;

    void update(Cargo objT) throws Exception;

    void delete(Long id) throws Exception;

    Cargo findById(Long id) throws Exception;

    List<Cargo> findAll() throws Exception;

}
