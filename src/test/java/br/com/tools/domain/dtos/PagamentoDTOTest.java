package br.com.tools.domain.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PagamentoDTOTest {

    @Test
    void testPagamentoDTONonNullTransacao() {

        String cartao = "4444123456781234";
        String id = "100023568900001";
        DescricaoDTO descricao = new DescricaoDTO(500.5, "01/05/2021 18:30:00", "PetShop Mundo Cão");
        FormaPagamentoDTO formaPagamento = new FormaPagamentoDTO("AVISTA", 1);

        TransacaoDTO transacaoDTO = new TransacaoDTO(cartao, id, descricao, formaPagamento);

        assertDoesNotThrow(() -> new PagamentoDTO(transacaoDTO));
    }

    @Test
    void testPagamentoDTONullTransacao() {
        assertThrows(NullPointerException.class, () -> new PagamentoDTO(null));
    }
}
