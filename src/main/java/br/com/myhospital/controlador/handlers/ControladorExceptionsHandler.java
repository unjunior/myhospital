package br.com.myhospital.controlador.handlers;

import br.com.myhospital.dto.excecoesDto.ErrosCustomizadosDto;
import br.com.myhospital.servicos.exceptions.DatabaseExceptionServico;
import br.com.myhospital.servicos.exceptions.EntidadeNaoProcessada;
import br.com.myhospital.servicos.exceptions.ExceptionsGenericasServico;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControladorExceptionsHandler {

    @ExceptionHandler(ExceptionsGenericasServico.class)
    public ResponseEntity<ErrosCustomizadosDto> idNaoEncontrado(ExceptionsGenericasServico e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrosCustomizadosDto erro = new ErrosCustomizadosDto(Instant.now(), status.value(),
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(DatabaseExceptionServico.class)
    public ResponseEntity<ErrosCustomizadosDto> database(DatabaseExceptionServico e, HttpServletRequest request){

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrosCustomizadosDto erro = new ErrosCustomizadosDto(Instant.now(), status.value(),
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(EntidadeNaoProcessada.class)
    public ResponseEntity<ErrosCustomizadosDto> horario(EntidadeNaoProcessada e, HttpServletRequest request){

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ErrosCustomizadosDto erro = new ErrosCustomizadosDto(Instant.now(), status.value(),
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(erro);
    }



}
