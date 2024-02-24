package br.com.tools.domain.response.wrapper;

import br.com.tools.domain.enums.StatusTransacao;
import br.com.tools.domain.transacao.Descricao;
import br.com.tools.domain.transacao.FormaPagamento;
import br.com.tools.domain.transacao.Transacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransacaoWrapperTest {

    @Test
    void testTransacaoWrapperEncapsulation() {
        Descricao descricao = new Descricao(300.0, "03/03/2020 12:00:00", "Eletrônicos TechPlus", "345678", "765432", StatusTransacao.NEGADO);
        FormaPagamento formaPagamento = new FormaPagamento("DEBITO", 0);
        Transacao transacao = new Transacao("3333444455556666", "trans003", descricao, formaPagamento);
        TransacaoWrapper transacaoWrapper = new TransacaoWrapper(transacao);

        assertEquals(transacao, transacaoWrapper.getTransacao());
    }
}
