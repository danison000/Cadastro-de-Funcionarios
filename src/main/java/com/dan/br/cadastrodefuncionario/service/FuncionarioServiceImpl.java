package com.dan.br.cadastrodefuncionario.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dan.br.cadastrodefuncionario.model.Funcionario;
import com.dan.br.cadastrodefuncionario.repository.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

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
    public List<Funcionario> findAll() throws Exception {

        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        if (funcionarios.isEmpty())
            throw new Exception("Não foi encontrado nenhum funcionario");

        return funcionarios;
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
    public List<Funcionario> findByDepartamento(Long id) throws Exception {

        List<Funcionario> funcionarios = funcionarioRepository.findByDepartamento(id);

        if (funcionarios.isEmpty())
            throw new Exception("Não há funcionarios neste departamento!");

        return funcionarios;

    }

    @Override
    public List<Funcionario> findBySalario(BigDecimal salario1, BigDecimal salario2) throws Exception {

        System.out.println(salario1+"  "+salario2);


        List<Funcionario> funcionarios = funcionarioRepository.findBySalario(salario1, salario2);
        if (funcionarios.isEmpty())
            throw new Exception("Não há funcionarios com essa faixa de salário!");

        return funcionarios;
    }

}
