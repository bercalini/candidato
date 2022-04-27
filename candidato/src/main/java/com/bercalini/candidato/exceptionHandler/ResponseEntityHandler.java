package com.bercalini.candidato.exceptionHandler;

import com.bercalini.candidato.exception.CandidatoNaoEncontradoException;
import com.bercalini.candidato.exceptionHandler.problema.Problema;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Log4j2
public class ResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CandidatoNaoEncontradoException.class)
    protected ResponseEntity<Object> handleCandidatoNaoEncontradoException(Exception ex, WebRequest request) {
        log.error(ex.getMessage());
        Problema problema = Problema.builder().data(LocalDateTime.now()).status(HttpStatus.NOT_FOUND.value()).mensagem(ex.getMessage()).build();
        return handleExceptionInternal(ex, problema, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}
