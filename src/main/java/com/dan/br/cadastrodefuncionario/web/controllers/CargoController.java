package com.dan.br.cadastrodefuncionario.web.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.br.cadastrodefuncionario.model.Cargo;
import com.dan.br.cadastrodefuncionario.service.CargoService;
import com.dan.br.cadastrodefuncionario.web.Converters.Conversor;
import com.dan.br.cadastrodefuncionario.web.DTO.CargoDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("api/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;
  
    @Autowired
    private Conversor conversor;

    @GetMapping
    public ResponseEntity<List<CargoDTO>> listarTodos() throws Exception {

        List<CargoDTO> cargosDto =  conversor.cargoToDto(cargoService.findAll());
        return ResponseEntity.ok(cargosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> buscarPorId(@PathVariable(name = "id") Long id) throws Exception {

        return ResponseEntity.ok(cargoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid CargoDTO cargoDto) throws Exception {

        cargoService.save(conversor.dtoToCargo(cargoDto));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> atualizar(@RequestBody @Valid CargoDTO cargoDto) throws Exception {

        cargoService.update(conversor.dtoToCargo(cargoDto));

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable(name = "id") Long id) throws Exception {

        cargoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
