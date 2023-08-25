package com.dan.br.cadastrodefuncionario.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity @Table(name = "ENDERECOS")
public class Endereco extends AbstractId<Long> {
    @NotBlank(message = "campo logradouro em branco")
    @Column(nullable = false, length = 30)
    private String logradouro;

    @NotNull(message = "campo numero em branco")
    @Column(nullable = false, length = 5)
    private Integer numero;

    @NotBlank(message = "campo bairro em branco")
    @Column(nullable = false, length = 30)
    private String bairro;

    @NotBlank(message = "campo cidade em branco")
    @Column(nullable = false, length = 30)
    private String cidade;

    @NotNull(message = "selecione uma uf")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 2)
    private UF uf;

    @NotBlank(message = "digite um cep")
    @Size(min = 9, max = 9, message = "deveter 9 digitos")
    @Column(nullable = false, length = 9)
    private String cep;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade
                + ", uf=" + uf + ", cep=" + cep + "]";
    }


    

    

}
