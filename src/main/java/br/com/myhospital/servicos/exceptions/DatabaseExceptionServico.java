package br.com.myhospital.servicos.exceptions;

public class DatabaseExceptionServico extends RuntimeException{
    public DatabaseExceptionServico(String message) {
        super(message);
    }
}
