package com.dan.br.cadastrodefuncionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dan.br.cadastrodefuncionario.DTO.FuncionarioDTO;
import com.dan.br.cadastrodefuncionario.model.Funcionario;
import com.dan.br.cadastrodefuncionario.repository.FuncionarioRepository;
import com.dan.br.cadastrodefuncionario.web.Converters.ConversorImpl;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ConversorImpl conversor;

    @Override
    public void save(Funcionario funcionario) {

        funcionarioRepository.save(funcionario);

    }

    @Override
    public void update(Funcionario funcionario) throws Exception {

        findById(funcionario.getId());

        save(funcionario);
    }

    @Override
    public void delete(Long id) throws Exception {

        findById(id);

        funcionarioRepository.deleteById(id);
    }

    @Override
    public Funcionario findById(Long id) throws Exception {

        return funcionarioRepository.findById(id).orElseThrow(() -> new Exception("Funcionário não encontrado!"));
    }

    @Override
    public List<FuncionarioDTO> findAll() throws Exception {

        List<FuncionarioDTO> funcionariosDto = conversor.funcionarioToDto(funcionarioRepository.findAll());

        if (funcionariosDto.isEmpty())
            throw new Exception("Não foi encontrado nenhum Funcionário");

        return funcionariosDto;
    }

    @Override
    public List<Funcionario> findByName(String nome) throws Exception {

        List<Funcionario> funcionarios = funcionarioRepository.findByName(nome);

        for (Funcionario f : funcionarios) {
            System.out.println(f.toString());
        }

        if (funcionarios.isEmpty())
            throw new Exception("Não há funcionario com este nome!");

        return funcionarios;
    }

    @Override
    public List<Funcionario> findByCargo(Long id) throws Exception {

        List<Funcionario> funcionarios = funcionarioRepository.findByCargo(id).get();

        if (funcionarios.isEmpty())
            throw new Exception("Não há funcionario com neste cargo!");

        return funcionarios;

    }

}
