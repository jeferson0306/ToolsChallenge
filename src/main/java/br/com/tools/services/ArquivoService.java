package br.com.tools.services;

import br.com.tools.domain.transacao.Transacao;
import br.com.tools.domain.response.wrapper.TransacaoWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArquivoService {

    private final ObjectMapper objectMapper;

    public List<Transacao> lerArquivoDeTransacoesMockado() throws IOException {
        log.info("iniciando a leitura do arquivo de transacoes mockado no path transacoes/mock.json");
        final var resource = new ClassPathResource("transacoes/mock.json");
        final TransacaoWrapper[] wrappers = objectMapper.readValue(resource.getInputStream(), TransacaoWrapper[].class);
        final var transacoes = stream(wrappers).map(TransacaoWrapper::getTransacao).toList();
        log.info("finalizando a leitura do arquivo de transacoes");
        return transacoes;
    }

}
