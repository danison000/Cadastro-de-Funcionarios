package com.dan.br.cadastrodefuncionario.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dan.br.cadastrodefuncionario.model.UF;

@Controller
@RequestMapping
public class ViewsController {


    @GetMapping({"/home", "/"})
    public String home() {

        return "home";
    }

    @GetMapping("/funcionarios")
    public String funcionariosListar() {

        return "funcionario/listar";
    }

    @GetMapping("/funcionarios/cadastro")
    public String funcionarioCadastro() {
        return "funcionario/cadastro";
    }

    @GetMapping("/cargos")
    public String cargoListar() {
        return "cargo/listar";
    }

    @GetMapping("/cargos/cadastro")
    public String cargoCadastro() {
        return "cargo/cadastro";
    }

    @GetMapping("/departamentos")
    public String departamentosListar() {
        return "departamento/listar";
    }

    @GetMapping("/departamentos/cadastrar")
    public String departamentosCadastro() {
        return "departamento/cadastro";
    }

    @ResponseBody
    @GetMapping("/ufs")
    public UF[] getUfs() {

        return UF.values();
    }

}
