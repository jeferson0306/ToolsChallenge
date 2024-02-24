package br.com.tools.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransacaoNaoEncontradaExceptionTest {

    @Test
    void testExceptionMessageWithId() {
        String transactionId = "123456";
        TransacaoNaoEncontradaException exception = new TransacaoNaoEncontradaException(transactionId);

        assertEquals("Transação não encontrada para o ID: " + transactionId, exception.getMessage());
    }
}
