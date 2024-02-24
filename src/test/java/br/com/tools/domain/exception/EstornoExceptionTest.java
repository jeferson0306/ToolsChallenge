package br.com.tools.domain.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EstornoExceptionTest {

    @Test
    void testExceptionMessage() {
        String expectedMessage = "Estorno não permitido para a transação.";
        EstornoException exception = new EstornoException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage());
    }
}
