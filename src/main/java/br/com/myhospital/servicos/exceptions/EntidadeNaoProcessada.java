package br.com.myhospital.servicos.exceptions;

public class EntidadeNaoProcessada extends RuntimeException {
    public EntidadeNaoProcessada(String msg) {
        super(msg);
    }
}
