package br.com.myhospital.controlador.handlers;

import br.com.myhospital.dto.ErrosCustomizadosDto;
import br.com.myhospital.servicos.exceptions.ExceptionsGenericasServico;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class HandlerControladorExceptions {

    @ExceptionHandler(ExceptionsGenericasServico.class)
    public ResponseEntity<ErrosCustomizadosDto> idNaoEncontrado(ExceptionsGenericasServico e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrosCustomizadosDto erro = new ErrosCustomizadosDto(Instant.now(), status.value(),
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(erro);
    }
}
