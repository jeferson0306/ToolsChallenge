package br.com.tools.domain.response;

import br.com.tools.domain.enums.StatusTransacao;
import br.com.tools.domain.transacao.Descricao;
import br.com.tools.domain.transacao.FormaPagamento;
import br.com.tools.domain.transacao.Transacao;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransacoesResponseTest {

    @Test
    void shouldThrowNullPointerExceptionForNullTransacoesList() {
        assertThrows(NullPointerException.class, () -> new TransacoesResponse(null), "O campo 'transacao' não pode ser nulo");
    }

    @Test
    void shouldCreateTransacoesResponseWithNonNullTransacoesList() {
        Descricao descricao = new Descricao(200.0, "02/02/2020 11:00:00", "Eletrônicos TechPlus", "789012", "987654", StatusTransacao.AUTORIZADO);
        FormaPagamento formaPagamento = new FormaPagamento("PARCELADO_LOJA", 2);
        Transacao transacao = new Transacao("2222333344445555", "trans002", descricao, formaPagamento);
        List<Transacao> transacoes = Collections.singletonList(transacao);

        TransacoesResponse response = new TransacoesResponse(transacoes);

        assertNotNull(response);
        assertFalse(response.transacao().isEmpty());
        assertEquals(transacao, response.transacao().get(0));
    }
}
