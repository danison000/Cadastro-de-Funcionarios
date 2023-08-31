package com.dan.br.cadastrodefuncionario.web.Util;

public enum MappedApi {

    FUNCIONARIOS( "/api/funcionarios", "/funcionarios"),
    CARGOS("/api/cargos", "localhost:8080/cargos"),
    DEPARTAMENTOS("/api/departamentos", "localhost:8080/departamentos");

 
    private String uriOrigin;
    private String uriRedirect;

    private MappedApi(String uri, String url) {
        this.uriOrigin = url;
        this.uriRedirect = uri;
    }


    public String getUriRedirect() {
        return uriRedirect;
    }


    public String getUrlOrigin() {
        return uriOrigin;
    }

   
}
