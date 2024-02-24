package br.com.tools.domain.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormaDePagamentoTest {

    @Test
    void testEnumValues() {
        assertEquals("AVISTA", FormaDePagamento.AVISTA.getTipo());
        assertEquals("PARCELADO_EMISSOR", FormaDePagamento.PARCELADOEMISSOR.getTipo());
        assertEquals("PARCELADO_LOJA", FormaDePagamento.PARCELADOLOJA.getTipo());
    }
}
