package br.com.tools.controller;

import br.com.tools.domain.dtos.PagamentoDTO;
import br.com.tools.domain.response.PagamentoResponse;
import br.com.tools.services.PagamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @PostMapping("/processar")
    public ResponseEntity<PagamentoResponse> processarPagamento(@RequestBody final PagamentoDTO pagamentoDTO) throws URISyntaxException {
        log.info("iniciando o processamento do pagamento {} para o id {}", pagamentoDTO, pagamentoDTO.transacao().id());
        final var respostaDoPagamento = pagamentoService.processarPagamento(pagamentoDTO);
        log.info("finalizando o processamento do pagamento {} para o id {}", pagamentoDTO, pagamentoDTO.transacao().id());
        return ok(respostaDoPagamento);
    }

}
