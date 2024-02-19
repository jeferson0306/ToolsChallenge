package br.com.tools.domain.exception;

public class TransacaoNaoEncontradaException extends RuntimeException {

    public TransacaoNaoEncontradaException(String id) {
        super("Transação não encontrada para o ID: " + id);
    }

}
