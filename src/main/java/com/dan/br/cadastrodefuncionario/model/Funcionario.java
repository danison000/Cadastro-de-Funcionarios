package com.dan.br.cadastrodefuncionario.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Funcionario
 */
@Entity @Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractId<Long>{

    @NotBlank(message = "campo nome em branco")
    @Column(nullable = false)
    private String nome;

    @Valid
    @ManyToOne
    @JoinColumn(name = "CARGO_ID_FK")
    private Cargo cargo;
    
    @NotNull(message = "campo salario em branco")
    @Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.0")
    private BigDecimal salario;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ENDERECO_ID_FK")
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", cargo=" + cargo + ", salario=" + salario + ", endereco=" + endereco
                + "]";
    }

    

    
}