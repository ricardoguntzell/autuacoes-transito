package br.com.guntz.transito.api.domain.exception;

public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException() {
    }

    public RecursoNaoEncontradoException(String message) {
        super(message);
    }
}
