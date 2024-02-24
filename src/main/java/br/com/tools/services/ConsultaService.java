package br.com.tools.services;

import br.com.tools.domain.exception.TransacaoNaoEncontradaException;
import br.com.tools.domain.response.TransacaoResponse;
import br.com.tools.domain.response.TransacoesResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ArquivoService arquivoService;

    public TransacoesResponse consultarTransacoes() {

        log.info("iniciando a consulta de transacoes");

        final var transacoes = arquivoService.lerArquivoDeTransacoesMockado();

        if (transacoes.isEmpty()) {
            log.error("finalizando a consulta de transacoes com erro pois a lista de transacoes esta vazia");
            throw new TransacaoNaoEncontradaException("Nenhuma transação encontrada.");
        }

        log.info("finalizando a consulta de transacoes com o retorno: {}", transacoes);
        return new TransacoesResponse(transacoes);
    }

    public TransacaoResponse consultarTransacaoPorId(final String id) {

        log.info("inicia a consulta de transacao para o id {}", id);

        final var transacoes = arquivoService.lerArquivoDeTransacoesMockado();
        final var transacaoEncontrada = transacoes.stream().filter(transacao -> transacao.id().equals(id)).findFirst().orElseThrow(() -> new TransacaoNaoEncontradaException("Transação não encontrada para o id informado" + id));

        log.info("finaliza a consulta de transacao para o id {} com o retorno: {}", id, transacaoEncontrada);
        return new TransacaoResponse(transacaoEncontrada);
    }


}
