package br.com.tools.controller;

import br.com.tools.domain.response.TransacaoResponse;
import br.com.tools.domain.response.TransacoesResponse;
import br.com.tools.services.ConsultaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping("/todos")
    public ResponseEntity<TransacoesResponse> consultarTransacoes() throws Exception {
        log.info("inicia a consulta de transacoes");
        final var transacoes = consultaService.consultarTransacoes();
        log.info("finaliza a consulta de transacoes com o retorno: {}", transacoes);
        return ok(transacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoResponse> consultarTransacao(@PathVariable final String id) throws Exception {
        log.info("inicia a consulta de transacao para o id {}", id);
        final var transacao = consultaService.consultarTransacaoPorId(id);
        log.info("finaliza a consulta de transacao para o id {} com o retorno: {}", id, transacao);
        return ok(transacao);
    }

}
