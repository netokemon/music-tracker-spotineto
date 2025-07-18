package com.neto.spotineto.excecoes;

public class APISemTokenException extends RuntimeException {

    private String mensagem;

    public APISemTokenException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
