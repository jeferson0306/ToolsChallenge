package br.com.tools.domain.transacao;

public record Transacao(String cartao, String id, Descricao descricao, FormaPagamento formaPagamento) {
}
