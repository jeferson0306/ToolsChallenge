package br.com.tools.domain.transacao;

import br.com.tools.domain.enums.StatusTransacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DescricaoTest {

    @Test
    void testDescricaoRecord() {
        double valor = 100.0;
        String dataHora = "10/10/2020 10:00:00";
        String estabelecimento = "Loja de Departamentos GrandeCompra";
        String nsu = "123456789";
        String codigoAutorizacao = "987654321";
        StatusTransacao status = StatusTransacao.AUTORIZADO;

        Descricao descricao = new Descricao(valor, dataHora, estabelecimento, nsu, codigoAutorizacao, status);

        assertEquals(valor, descricao.valor());
        assertEquals(dataHora, descricao.dataHora());
        assertEquals(estabelecimento, descricao.estabelecimento());
        assertEquals(nsu, descricao.nsu());
        assertEquals(codigoAutorizacao, descricao.codigoAutorizacao());
        assertEquals(status, descricao.status());
    }
}
