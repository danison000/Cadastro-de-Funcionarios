package com.dan.br.cadastrodefuncionario.DTO;

import java.math.BigDecimal;

import com.dan.br.cadastrodefuncionario.model.Endereco;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FuncionarioDTO {

    private Long id;

    @NotBlank(message = "Campo nome em branco")
    private String nome;

    @NotNull(message = "selecione um cargo")
    private Long cargoId;

    private String cargoNome;

    private String departamentoNome;

    @NotNull(message = "campo salario em branco")
    private BigDecimal salario;

    @Valid
    private Endereco endereco;

    public String getCargoNome() {
        return cargoNome;
    }

    public void setCargoNome(String cargoNome) {

        this.cargoNome = cargoNome;
    }

    public String getDepartamentoNome() {
        return departamentoNome;
    }

    public void setDepartamentoNome(String departamentoNome) {
        this.departamentoNome = departamentoNome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "FuncionarioDTO [nome=" + nome + ", cargoId=" + cargoId + ", salario=" + salario + ", endereco="
                + endereco.toString() + "]";
    }

}
