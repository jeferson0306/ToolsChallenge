package br.com.tools.domain.transacao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormaPagamentoTest {

    @Test
    void testFormaPagamentoRecord() {
        String tipo = "AVISTA";
        int parcelas = 1;

        FormaPagamento formaPagamento = new FormaPagamento(tipo, parcelas);

        assertEquals(tipo, formaPagamento.tipo());
        assertEquals(parcelas, formaPagamento.parcelas());
    }
}
