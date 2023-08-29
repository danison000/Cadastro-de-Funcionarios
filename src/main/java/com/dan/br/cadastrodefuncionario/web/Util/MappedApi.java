package com.dan.br.cadastrodefuncionario.web.Util;

public enum MappedApi {

    FUNCIONARIOS( "/api/funcionarios"),
    CARGOS("/api/cargos"),
    DEPARTAMENTOS("/api/departamentos");

 
    private String uri;

    private MappedApi(String uri) {
     
        this.uri = uri;
    }


    public String getUri() {
        return uri;
    }

   
}
