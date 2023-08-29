package com.dan.br.cadastrodefuncionario.web.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dan.br.cadastrodefuncionario.model.Departamento;
import com.dan.br.cadastrodefuncionario.service.DepartamentoService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> listarTodos() throws Exception {

        List<Departamento> departamentos = departamentoService.findAll();
        return ResponseEntity.ok(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarPorId(@PathVariable(name = "id") Long id) throws Exception {

        return ResponseEntity.ok(departamentoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid Departamento departamento) throws Exception {

        departamentoService.save(departamento);
        
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity<?> atualizar(@RequestBody @Valid Departamento departamento) throws Exception {

        departamentoService.update(departamento);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable(name = "id") Long id) throws Exception {

        departamentoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
