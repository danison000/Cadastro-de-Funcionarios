package com.dan.br.cadastrodefuncionario.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractId<Long> {

  
    @NotNull(message = "campo não pode ser nulo")
    @NotBlank(message = "digite um nome válido")
    @Column(nullable = false, length = 60, unique = true)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "departamento")
    private List<Cargo> cargos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

}
