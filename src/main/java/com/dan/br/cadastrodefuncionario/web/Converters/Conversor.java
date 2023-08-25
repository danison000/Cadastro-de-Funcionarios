package com.dan.br.cadastrodefuncionario.web.Converters;

import java.util.List;

import com.dan.br.cadastrodefuncionario.DTO.CargoDTO;
import com.dan.br.cadastrodefuncionario.DTO.FuncionarioDTO;
import com.dan.br.cadastrodefuncionario.model.Cargo;
import com.dan.br.cadastrodefuncionario.model.Funcionario;


public interface Conversor {

    Cargo dtoToCargo(CargoDTO cargoDto) throws Exception;

    List<CargoDTO> cargoToDto(List<Cargo> cargos);

    Funcionario dtoToFuncionario(FuncionarioDTO funcionarioDto) throws Exception;
    
    List<FuncionarioDTO> funcionarioToDto(List<Funcionario> funcionario);

    FuncionarioDTO funcionarioToDto(Funcionario funcionario);

}
