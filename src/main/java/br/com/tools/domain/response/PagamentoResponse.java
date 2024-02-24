package br.com.tools.domain.response;

import br.com.tools.domain.transacao.Transacao;

import static java.util.Objects.requireNonNull;

public record PagamentoResponse(Transacao transacao) {

    public PagamentoResponse {
        requireNonNull(transacao, "O campo 'transacao' não pode ser nulo");
    }

}
