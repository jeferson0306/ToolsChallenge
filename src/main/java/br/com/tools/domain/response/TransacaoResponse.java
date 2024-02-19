package br.com.tools.domain.response;

import br.com.tools.domain.transacao.Transacao;

import java.util.List;

import static java.util.Objects.requireNonNull;

public record TransacaoResponse(List<Transacao> transacao) {

    public TransacaoResponse {
        requireNonNull(transacao, "O campo 'transacao' não pode ser nulo");
    }

}
