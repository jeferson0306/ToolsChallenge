package br.com.tools.domain.transacao;

import br.com.tools.domain.enums.StatusTransacao;

public record Descricao(double valor, String dataHora, String estabelecimento, String nsu, String codigoAutorizacao,
                        StatusTransacao status) {
}
