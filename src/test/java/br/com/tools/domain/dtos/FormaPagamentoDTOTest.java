package br.com.tools.domain.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormaPagamentoDTOTest {

    @Test
    void testFormaPagamentoDTO() {
        String tipo = "AVISTA";
        int parcelas = 1;

        FormaPagamentoDTO formaPagamentoDTO = new FormaPagamentoDTO(tipo, parcelas);

        assertEquals(tipo, formaPagamentoDTO.tipo());
        assertEquals(parcelas, formaPagamentoDTO.parcelas());
    }
}
