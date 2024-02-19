package br.com.tools.services;

import br.com.tools.domain.Transacao;
import br.com.tools.domain.TransacaoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final ArquivoService arquivoService;

    public TransacaoResponse consultarTransacoes() throws IOException {
        log.info("iniciando a consulta de transacoes");
        final var transacoes = arquivoService.lerArquivoDeTransacoesMockado();
        log.info("finalizando a consulta de transacoes com o retorno: {}", transacoes);
        return new TransacaoResponse(transacoes);
    }

    public Transacao consultarTransacaoPorId(final String id) throws IOException {
        log.info("iniciando a consulta de transacao para o id {}", id);
        final var retorno = arquivoService.lerArquivoDeTransacoesMockado().stream().filter(transacao -> transacao.id().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Transação não encontrada."));
        log.info("finalizando a consulta de transacao para o id {} com o retorno: {}", id, retorno);
        return retorno;
    }
}
