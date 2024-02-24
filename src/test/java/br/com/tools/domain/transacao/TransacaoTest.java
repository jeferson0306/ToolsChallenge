package br.com.tools.domain.transacao;

import br.com.tools.domain.enums.StatusTransacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransacaoTest {

    @Test
    void testTransacaoRecord() {
        String cartao = "1111222233334444";
        String id = "0001";
        Descricao descricao = new Descricao(100.0, "12/12/2021 12:00", "Loja de Departamentos GrandeCompra", "123456", "654321", StatusTransacao.AUTORIZADO);
        FormaPagamento formaPagamento = new FormaPagamento("AVISTA", 1);

        Transacao transacao = new Transacao(cartao, id, descricao, formaPagamento);

        assertEquals(cartao, transacao.cartao());
        assertEquals(id, transacao.id());
        assertEquals(descricao, transacao.descricao());
        assertEquals(formaPagamento, transacao.formaPagamento());
    }
}
