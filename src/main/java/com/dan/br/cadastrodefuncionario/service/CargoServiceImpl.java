package com.dan.br.cadastrodefuncionario.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dan.br.cadastrodefuncionario.model.Cargo;
import com.dan.br.cadastrodefuncionario.repository.CargoRepository;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public void save(Cargo cargo) throws Exception {

        if (nomeAlreadyExistInDepartamento(cargo)) {

            throw new Exception("Já existe um cargo com este nome!");
        }
        cargoRepository.save(cargo);

    }

    @Override
    public void update(Cargo cargo) throws Exception  {

        findById(cargo.getId());

        save(cargo);
    }

    @Override
    public void delete(Long id) throws Exception {

        findById(id);
        cargoRepository.deleteById(id);
    }

    @Override
    public Cargo findById(Long id) throws Exception {

        return cargoRepository.findById(id).orElseThrow(() -> new Exception("Cargo não encontrado!"));
    }

    @Override
    public List<Cargo> findAll() throws Exception {

        List<Cargo> cargos = cargoRepository.findAll();

        if (cargos.isEmpty())
            throw new Exception("Nenhum Cargo Cadastrado");

        return cargos;
    }

    protected boolean nomeAlreadyExistInDepartamento(Cargo cargo) {

        return cargoRepository.findByNomeInDepartamento(cargo.getNome(), cargo.getDepartamento().getId()).isPresent();
    }

}
