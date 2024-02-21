package br.com.tools.services;

import br.com.tools.domain.response.wrapper.TransacaoWrapper;
import br.com.tools.domain.transacao.Transacao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArquivoService {

    private static final String FILE_PATH = "transacoes/mock.json";
    private final ObjectMapper objectMapper;

    public List<Transacao> lerArquivoDeTransacoesMockado() throws IOException {
        log.info("iniciando leitura do arquivo de transacoes mockado no path: {}", FILE_PATH);
        final var resource = new ClassPathResource(FILE_PATH);
        final List<TransacaoWrapper> transacaoWrappers = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
        });
        log.info("finalizando leitura do arquivo de transacoes mockado no path: {} com o retorno: {}", FILE_PATH, transacaoWrappers);
        return transacaoWrappers.stream().map(TransacaoWrapper::getTransacao).toList();
    }

}
