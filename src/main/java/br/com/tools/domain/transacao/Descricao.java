package br.com.tools.domain.transacao;

public record Descricao(double valor, String dataHora, String estabelecimento, String nsu, String codigoAutorizacao,
                        String status) {
}
