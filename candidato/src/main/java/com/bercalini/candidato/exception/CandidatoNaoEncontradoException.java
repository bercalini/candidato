package com.bercalini.candidato.exception;

public class CandidatoNaoEncontradoException extends RuntimeException{
    public CandidatoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
