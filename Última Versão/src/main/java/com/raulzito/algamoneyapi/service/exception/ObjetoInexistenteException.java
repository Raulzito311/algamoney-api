package com.raulzito.algamoneyapi.service.exception;

public class ObjetoInexistenteException extends RuntimeException {

    private String obj;

    public ObjetoInexistenteException(String obj) {
        this.obj = obj;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}
