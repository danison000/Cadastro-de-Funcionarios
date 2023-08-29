package com.dan.br.cadastrodefuncionario.web.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CargoDTO {


    private Long id;
    
    @NotNull(message = "selecione um departamento")
    private Long departamentoId;
   
    private String departamentoNome;
  
    @NotBlank(message = "campo em branco")
    private String nome;

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
    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    
}
