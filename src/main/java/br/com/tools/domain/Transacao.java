package br.com.tools.domain;

public record Transacao(String cartao, String id, Descricao descricao, FormaPagamento formaPagamento) {
}
