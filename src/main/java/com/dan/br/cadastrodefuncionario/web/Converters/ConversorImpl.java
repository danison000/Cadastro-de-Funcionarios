package com.dan.br.cadastrodefuncionario.web.Converters;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dan.br.cadastrodefuncionario.DTO.CargoDTO;
import com.dan.br.cadastrodefuncionario.DTO.FuncionarioDTO;
import com.dan.br.cadastrodefuncionario.model.Cargo;
import com.dan.br.cadastrodefuncionario.model.Funcionario;
import com.dan.br.cadastrodefuncionario.service.CargoService;
import com.dan.br.cadastrodefuncionario.service.DepartamentoService;

@Component
public class ConversorImpl implements Conversor {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private CargoService cargoService;

    @Override
    public Cargo dtoToCargo(CargoDTO cargoDto) throws Exception {

        Cargo cargo = new Cargo();

        cargo.setId(cargoDto.getId());
        cargo.setNome(cargoDto.getNome());
        cargo.setDepartamento(departamentoService.findById(cargoDto.getDepartamentoId()));

        return cargo;
    }

    @Override
    public Funcionario dtoToFuncionario(FuncionarioDTO funcionarioDto) throws Exception {

        Funcionario funcionario = new Funcionario();

        funcionario.setId(funcionarioDto.getId());
        funcionario.setNome(funcionarioDto.getNome());
        funcionario.setSalario(funcionarioDto.getSalario());
        funcionario.setEndereco(funcionarioDto.getEndereco());
        funcionario.setCargo(cargoService.findById(funcionarioDto.getCargoId()));

        System.out.println(funcionario.toString());

        return funcionario;

    }

    @Override
    public List<FuncionarioDTO> funcionarioToDto(List<Funcionario> funcionarios) {

        List<FuncionarioDTO> funcionariosDTO = new LinkedList<>();

        for (Funcionario funcionario : funcionarios) {

            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
            funcionarioDTO.setNome(funcionario.getNome());
            funcionarioDTO.setDepartamentoNome(funcionario.getCargo().getDepartamento().getNome());
            funcionarioDTO.setEndereco(funcionario.getEndereco());
            funcionarioDTO.setCargoNome(funcionario.getCargo().getNome());
            funcionarioDTO.setId(funcionario.getId());
            funcionarioDTO.setSalario(funcionario.getSalario());

            funcionariosDTO.add(funcionarioDTO);

        }

        return funcionariosDTO;
    }

    @Override
    public FuncionarioDTO funcionarioToDto(Funcionario funcionario) {

        if(funcionario == null) return null;

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

        funcionarioDTO.setNome(funcionario.getNome());
        funcionarioDTO.setDepartamentoNome(funcionario.getCargo().getDepartamento().getNome());
        funcionarioDTO.setEndereco(funcionario.getEndereco());
        funcionarioDTO.setCargoNome(funcionario.getCargo().getNome());
        funcionarioDTO.setId(funcionario.getId());
        funcionarioDTO.setSalario(funcionario.getSalario());
        funcionarioDTO.setCargoId(funcionario.getCargo().getId());

        return funcionarioDTO;
    }

    @Override
    public List<CargoDTO> cargoToDto(List<Cargo> cargos) {
        List<CargoDTO> cargosDto = new ArrayList<>();

        for(Cargo c: cargos){
            CargoDTO cargoDTO = new CargoDTO();
            cargoDTO.setId(c.getId());
            cargoDTO.setDepartamentoId(c.getDepartamento().getId());
            cargoDTO.setNome(c.getNome());
            cargoDTO.setDepartamentoNome(c.getDepartamento().getNome());

            cargosDto.add(cargoDTO);

        }


        
        return cargosDto;
    }

}
