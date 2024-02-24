package br.com.tools.domain.response;

import br.com.tools.domain.transacao.Transacao;

import static java.util.Objects.requireNonNull;

public record TransacaoResponse(Transacao transacao) {

    public TransacaoResponse {
        requireNonNull(transacao, "O campo 'transacao' não pode ser nulo");
    }

}
