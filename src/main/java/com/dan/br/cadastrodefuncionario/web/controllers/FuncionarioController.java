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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dan.br.cadastrodefuncionario.DTO.FuncionarioDTO;
import com.dan.br.cadastrodefuncionario.model.Funcionario;
import com.dan.br.cadastrodefuncionario.service.FuncionarioService;
import com.dan.br.cadastrodefuncionario.web.Converters.Conversor;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private Conversor conversor;

    @GetMapping
    public ResponseEntity<?> listarTodos() throws Exception {

        List<FuncionarioDTO> funcionariosDto = funcionarioService.findAll();

        return ResponseEntity.ok(funcionariosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarPorId(@PathVariable(name = "id") Long id) throws Exception {

        FuncionarioDTO funcionarioDto = conversor.funcionarioToDto(funcionarioService.findById(id));

        return ResponseEntity.ok(funcionarioDto);
    }

    @GetMapping("/buscar-por-nome")
    public ResponseEntity<List<Funcionario>> buscarPorNome(@RequestParam("nome") String nome) throws Exception {

        System.out.println(nome);
        if(nome.isBlank() || nome.isEmpty()) throw new Exception("Digite um nome");
        
        List<Funcionario> funcionarios = funcionarioService.findByName(nome);

        return ResponseEntity.ok(funcionarios);
    }

     @GetMapping("/buscar-por-cargo")
    public ResponseEntity<List<Funcionario>> buscarPorCargo(@RequestParam("id") Long id) throws Exception {

        List<Funcionario> funcionarios = funcionarioService.findByCargo(id);

        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid FuncionarioDTO funcionarioDto) throws Exception {

        funcionarioService.save(conversor.dtoToFuncionario(funcionarioDto));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> atualizar(@RequestBody @Valid FuncionarioDTO funcionarioDto) throws Exception {

        funcionarioService.update(conversor.dtoToFuncionario(funcionarioDto));

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> excluir(@PathVariable(name = "id") Long id) throws Exception {

        funcionarioService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
