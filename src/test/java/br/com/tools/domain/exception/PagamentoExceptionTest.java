package br.com.tools.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PagamentoExceptionTest {

    @Test
    void testExceptionMessage() {
        String expectedMessage = "Erro ao processar pagamento.";
        PagamentoException exception = new PagamentoException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage());
    }
}
