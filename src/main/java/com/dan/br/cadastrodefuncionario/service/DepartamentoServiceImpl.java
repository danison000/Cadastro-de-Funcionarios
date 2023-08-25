package com.dan.br.cadastrodefuncionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.dan.br.cadastrodefuncionario.model.Departamento;
import com.dan.br.cadastrodefuncionario.repository.DepartamentoRepository;

@Service

public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public void save(Departamento departamento) throws Exception {

        if (nameAlreadExist(departamento.getNome())) {
            throw new Exception("Já existe um departamento com esse nome!");
        }
        departamentoRepository.save(departamento);
    }

    @Override
    public void update(Departamento departamento) throws Exception {

        departamentoRepository.findById(departamento.getId())
                .orElseThrow(() -> new Exception("Departamento não encontrado"));
        save(departamento);
    }

    @Override
    public void delete(Long id) throws Exception {

        findById(id);

        departamentoRepository.deleteById(id);

    }

    @Override
    public Departamento findById(Long id) throws Exception {

        return departamentoRepository.findById(id).orElseThrow(() -> new Exception("Departamento não encontrado"));
    }

    @Override
    public List<Departamento> findAll() throws Exception {

        List<Departamento> funcionarios = departamentoRepository.findAll();

        if (funcionarios.isEmpty())
            throw new Exception("Não há Departamentos cadastrado");

        return funcionarios;
    }

    protected boolean nameAlreadExist(String nome) {

        return departamentoRepository.findByNome(nome).isPresent();

    }

}
