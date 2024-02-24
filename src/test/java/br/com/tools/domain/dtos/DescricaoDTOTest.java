package br.com.tools.domain.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DescricaoDTOTest {

    @Test
    void testDescricaoDTO() {
        double valor = 500.5;
        String dataHora = "01/05/2021 18:30:00";
        String estabelecimento = "PetShop Mundo Cão";

        DescricaoDTO descricaoDTO = new DescricaoDTO(valor, dataHora, estabelecimento);

        assertEquals(valor, descricaoDTO.valor());
        assertEquals(dataHora, descricaoDTO.dataHora());
        assertEquals(estabelecimento, descricaoDTO.estabelecimento());
    }
}
