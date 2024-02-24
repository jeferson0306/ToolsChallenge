package br.com.tools.domain.exception;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarregarArquivoMockadoExceptionTest {

    @Test
    void testExceptionMessageAndCause() {
        Exception cause = new IOException("Falha ao carregar o arquivo");
        CarregarArquivoMockadoException exception = new CarregarArquivoMockadoException("Falha ao carregar o arquivo", cause);

        assertEquals("Falha ao carregar o arquivo", exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertTrue(exception.getCause() instanceof IOException);
    }
}
