package br.com.tools.domain.response;

import br.com.tools.domain.enums.StatusTransacao;
import br.com.tools.domain.transacao.Descricao;
import br.com.tools.domain.transacao.FormaPagamento;
import br.com.tools.domain.transacao.Transacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoResponseTest {

    @Test
    void shouldThrowNullPointerExceptionIfTransacaoIsNull() {
        assertThrows(NullPointerException.class, () -> new PagamentoResponse(null));
    }

    @Test
    void shouldCreatePagamentoResponseSuccessfully() {
        Descricao descricao = new Descricao(100.0, "01/01/2020 10:00:00", "Loja de Departamentos GrandeCompra", "123456", "654321", StatusTransacao.AUTORIZADO);
        FormaPagamento formaPagamento = new FormaPagamento("AVISTA", 1);
        Transacao transacao = new Transacao("1111222233334444", "trans001", descricao, formaPagamento);

        PagamentoResponse response = new PagamentoResponse(transacao);

        assertNotNull(response);
        assertEquals(transacao, response.transacao());
    }
}
