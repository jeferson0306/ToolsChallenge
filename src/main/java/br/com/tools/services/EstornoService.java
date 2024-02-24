package br.com.tools.services;

import br.com.tools.domain.exception.EstornoException;
import br.com.tools.domain.response.PagamentoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static br.com.tools.domain.enums.StatusTransacao.CANCELADO;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstornoService {

    private final ArquivoService arquivoService;

    public PagamentoResponse processarEstornoPorId(final String id) {

        log.info("iniciando a consulta do estorno para o id {}", id);

        final var transacoes = arquivoService.lerArquivoDeTransacoesMockado();
        final var transacaoEncontrada = transacoes.stream().filter(transacao -> transacao.id().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Transação não encontrada."));

        if (!transacaoEncontrada.descricao().status().equals(CANCELADO)) {
            log.error("finalizando a consulta do estorno para o id {} com erro pois o status {} e diferente de cancelado", id, transacaoEncontrada.descricao().status());
            throw new EstornoException("A transação não está com o status CANCELADO e não pode ser estornada.");
        }

        log.info("finalizando a consulta do estorno para o id {}", id);
        return new PagamentoResponse(transacaoEncontrada);
    }

}
