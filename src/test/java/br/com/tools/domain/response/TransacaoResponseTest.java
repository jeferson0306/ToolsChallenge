package br.com.tools.domain.response;

import br.com.tools.domain.enums.StatusTransacao;
import br.com.tools.domain.transacao.Descricao;
import br.com.tools.domain.transacao.FormaPagamento;
import br.com.tools.domain.transacao.Transacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoResponseTest {

    @Test
    void shouldThrowNullPointerExceptionForNullTransacao() {
        assertThrows(NullPointerException.class, () -> new TransacaoResponse(null));
    }

    @Test
    void shouldCreateTransacaoResponseWithValidTransacao() {
        Descricao descricao = new Descricao(200.0, "02/02/2020 10:00:00", "Online Shop", "789012", "987654", StatusTransacao.AUTORIZADO);
        FormaPagamento formaPagamento = new FormaPagamento("PARCELADO_LOJA", 2);
        Transacao transacao = new Transacao("5555666677778888", "trans002", descricao, formaPagamento);

        TransacaoResponse response = new TransacaoResponse(transacao);

        assertNotNull(response);
        assertEquals(transacao, response.transacao());
    }
}
