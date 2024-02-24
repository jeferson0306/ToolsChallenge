package br.com.tools.controller;

import br.com.tools.domain.response.PagamentoResponse;
import br.com.tools.services.EstornoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/estornos")
public class EstornoController {

    private final EstornoService estornoService;

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponse> processarEstornoPorId(@PathVariable final String id) {
        log.info("iniciando o processamento do estorno para o id {}", id);
        final var respostaEstorno = estornoService.processarEstornoPorId(id);
        log.info("finalizando o processamento do estorno para o id {}", id);
        return ok(respostaEstorno);
    }

}
