package br.com.tools.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        log.info("inicia a inicializando o object mapper");
        final var objectMapper = new ObjectMapper();
        log.info("finaliza a inicializando o object mapper");
        return objectMapper;
    }
}
