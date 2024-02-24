package br.com.tools.domain.dtos;

import static java.util.Objects.requireNonNull;

public record PagamentoDTO(TransacaoDTO transacao) {

    public PagamentoDTO {
        requireNonNull(transacao, "O campo 'transacao' não pode ser nulo");
    }

}
