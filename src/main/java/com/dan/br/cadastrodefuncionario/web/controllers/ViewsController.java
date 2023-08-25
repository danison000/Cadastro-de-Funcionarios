package com.dan.br.cadastrodefuncionario.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dan.br.cadastrodefuncionario.model.UF;

@Controller
@RequestMapping
public class ViewsController {

    @RequestMapping("/")
    public String redirect() {

        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home() {

        return "home";
    }

    @RequestMapping("/funcionarios")
    public String funcionariosListar() {

        return "funcionario/listar";
    }

    @RequestMapping("/funcionarios/cadastro")
    public String funcionarioCadastro() {
        return "funcionario/cadastro";
    }

    @RequestMapping("/cargos")
    public String cargoListar() {
        return "cargo/listar";
    }

    @RequestMapping("/cargos/cadastro")
    public String cargoCadastro() {
        return "cargo/cadastro";
    }

    @RequestMapping("/departamentos")
    public String departamentosListar() {
        return "departamento/listar";
    }

    @RequestMapping("/departamentos/cadastrar")
    public String departamentosCadastro() {
        return "departamento/cadastro";
    }

    @ResponseBody
    @RequestMapping("/ufs")
    public UF[] getUfs() {

        return UF.values();
    }

}
