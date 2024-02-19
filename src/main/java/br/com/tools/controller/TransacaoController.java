package br.com.tools.controller;

import br.com.tools.domain.Transacao;
import br.com.tools.domain.TransacaoResponse;
import br.com.tools.services.TransacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @GetMapping("/all")
    public TransacaoResponse consultarTransacoes() throws Exception {
        log.info("inicia a consulta de transacoes");
        final var retorno = transacaoService.consultarTransacoes();
        log.info("finaliza a consulta de transacoes com o retorno: {}", retorno);
        return retorno;
    }

    @GetMapping("/{id}")
    public Transacao consultarTransacao(@PathVariable final String id) throws Exception {
        log.info("inicia a consulta de transacao para o id {}", id);
        final var retorno = transacaoService.consultarTransacaoPorId(id);
        log.info("finaliza a consulta de transacao para o id {} com o retorno: {}", id, retorno);
        return retorno;
    }
}
