package br.com.tools.domain.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatusTransacaoTest {

    @Test
    void testEnumStatus() {
        assertEquals("AUTORIZADO", StatusTransacao.AUTORIZADO.getStatus());
        assertEquals("NEGADO", StatusTransacao.NEGADO.getStatus());
        assertEquals("CANCELADO", StatusTransacao.CANCELADO.getStatus());
    }
}
