package br.com.tools.domain.dtos;

public record TransacaoDTO(String cartao, String id, DescricaoDTO descricao, FormaPagamentoDTO formaPagamento) {
}
