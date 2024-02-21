package br.com.tools.services;

import br.com.tools.domain.response.TransacaoResponse;
import br.com.tools.domain.response.TransacoesResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ArquivoService arquivoService;

    public TransacoesResponse consultarTransacoes() throws IOException {
        log.info("iniciando a consulta de transacoes");
        final var transacoes = arquivoService.lerArquivoDeTransacoesMockado();
        log.info("finalizando a consulta de transacoes com o retorno: {}", transacoes);
        return new TransacoesResponse(transacoes);
    }

    public TransacaoResponse consultarTransacaoPorId(final String id) throws IOException {
        log.info("inicia a consulta de transacao para o id {}", id);
        final var transacoes = arquivoService.lerArquivoDeTransacoesMockado();
        final var transacaoEncontrada = transacoes.stream().filter(transacao -> transacao.id().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Transação não encontrada."));
        log.info("finaliza a consulta de transacao para o id {} com o retorno: {}", id, transacaoEncontrada);
        return new TransacaoResponse(transacaoEncontrada);
    }


}
