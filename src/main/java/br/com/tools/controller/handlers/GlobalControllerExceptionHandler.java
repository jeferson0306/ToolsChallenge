package br.com.tools.controller.handlers;

import br.com.tools.domain.exception.CarregarArquivoMockadoException;
import br.com.tools.domain.exception.EstornoException;
import br.com.tools.domain.exception.PagamentoException;
import br.com.tools.domain.exception.TransacaoNaoEncontradaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CarregarArquivoMockadoException.class)
    public ResponseEntity<String> handleCarregarArquivoMockadoException(final CarregarArquivoMockadoException exception) {
        log.info("nao foi possivel carregar o arquivo mockado");
        return status(INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(EstornoException.class)
    public ResponseEntity<String> handleEstornoException(final EstornoException exception) {
        log.info("nao foi localizado status cancelado para o id informado na base de dados");
        return status(NOT_FOUND).body(exception.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(PagamentoException.class)
    public ResponseEntity<String> handlePagamentoException(final PagamentoException exception) {
        log.info("nao foi possivel realizar o pagamento para o id informado");
        return status(BAD_REQUEST).body(exception.getMessage());
    }

    @ResponseStatus(OK)
    @ExceptionHandler(TransacaoNaoEncontradaException.class)
    public ResponseEntity<String> handleTransacaoNaoEncontradaException(final TransacaoNaoEncontradaException exception) {
        log.info("nao foi localizada nenhuma transacao para o id informado na base de dados");
        return status(OK).body(exception.getMessage());
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(final Exception exception) {
        log.error("ocorreu um erro interno no servidor", exception);
        return status(INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

}
