package br.com.tools.services;

import br.com.tools.domain.exception.CarregarArquivoMockadoException;
import br.com.tools.domain.response.wrapper.TransacaoWrapper;
import br.com.tools.domain.transacao.Transacao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArquivoService {

    private static final String FILE_PATH = "transacoes/mock.json";

    private final ObjectMapper objectMapper;

    public List<Transacao> lerArquivoDeTransacoesMockado() {

        try {
            log.info("iniciando leitura do arquivo de transacoes mockado no path: {}", FILE_PATH);

            final var resource = new ClassPathResource(FILE_PATH);

            final List<TransacaoWrapper> transacaoWrappers = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
            });

            log.info("finalizando leitura do arquivo de transacoes mockado no path: {} com o retorno: {}", FILE_PATH, transacaoWrappers);
            return transacaoWrappers.stream().map(TransacaoWrapper::getTransacao).toList();
        } catch (IOException e) {
            log.error("finalizando leitura do arquivo de transacoes mockado no path: {} com erro: ", FILE_PATH, e);
            throw new CarregarArquivoMockadoException("Erro ao carregar o arquivo de transações mockado.", e);
        }
    }

    public void salvarTransacaoNoArquivo(final Transacao transacao) throws URISyntaxException {

        try {
            log.info("inicia o processo para salvar a transacao no arquivo: {} no path: {}", transacao, FILE_PATH);

            final List<TransacaoWrapper> transacaoWrappers = objectMapper.readValue(new ClassPathResource(FILE_PATH).getInputStream(), new TypeReference<>() {
            });

            log.info("adicionando a nova transacao no arquivo com os dados: {}", transacao);
            transacaoWrappers.add(new TransacaoWrapper(transacao));

            objectMapper.writeValue(Paths.get(ClassLoader.getSystemResource(FILE_PATH).toURI()).toFile(), transacaoWrappers);
            log.info("finalizando o processo para salvar a transacao no arquivo: {} no path: {}", transacao, FILE_PATH);
        } catch (IOException e) {
            log.error("finalizando o processo para salvar a transacao no arquivo: {} no path: {} com erro: ", transacao, FILE_PATH, e);
            throw new CarregarArquivoMockadoException("Erro ao salvar a transação no arquivo mockado.", e);
        }
    }

}
