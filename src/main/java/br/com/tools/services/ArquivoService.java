package br.com.tools.services;

import br.com.tools.domain.Transacao;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArquivoService {

    private final ObjectMapper objectMapper;

    public List<Transacao> lerArquivoDeTransacoesMockado() throws IOException {
        log.info("iniciando a leitura do arquivo de transacoes mockado no path transacoes/mock.json");
        final var resource = new ClassPathResource("transacoes/mock.json");
        final var retorno = asList(objectMapper.readValue(resource.getInputStream(), Transacao[].class));
        log.info("finalizando a leitura do arquivo de transacoes com o retorno: {}", resource);
        return retorno;
    }

}
