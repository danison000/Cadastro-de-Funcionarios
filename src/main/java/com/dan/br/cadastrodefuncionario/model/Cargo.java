package com.dan.br.cadastrodefuncionario.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity @Table(name = "CARGOS")
public class Cargo extends AbstractId<Long>{

    @NotNull(message = "campo não pode ser nulo")
    @NotBlank(message = "digite um nome válido")
    @Column(nullable = false)
    private String nome;

    @Valid
    @ManyToOne
    @JoinColumn(name = "departamento_id_fk")
    private Departamento departamento;

    @JsonIgnore
    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Cargo [nome=" + nome + ", departamento=" + departamento + "]";
    }

    

    
}
