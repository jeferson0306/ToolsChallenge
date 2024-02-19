package br.com.tools.services;

import br.com.tools.domain.response.TransacaoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static java.util.Collections.singletonList;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ArquivoService arquivoService;

    public TransacaoResponse consultarTransacoes() throws IOException {
        log.info("iniciando a consulta de transacoes");
        final var transacoes = arquivoService.lerArquivoDeTransacoesMockado();
        final var lsTransacoes = transacoes.stream().toList();
        log.info("finalizando a consulta de transacoes com o retorno: {}", lsTransacoes);
        return new TransacaoResponse(lsTransacoes);
    }


    public TransacaoResponse consultarTransacaoPorId(final String id) throws IOException {
        log.info("iniciando a consulta de transacao para o id {}", id);
        final var transacao = arquivoService.lerArquivoDeTransacoesMockado().stream().filter(t -> t.id().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Transação não encontrada."));
        log.info("finalizando a consulta de transacao para o id {} com o retorno: {}", id, transacao);
        return new TransacaoResponse(singletonList(transacao));
    }

}
