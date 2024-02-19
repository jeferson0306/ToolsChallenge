package br.com.tools.domain.exception;

public class CarregarArquivoMockadoException extends RuntimeException {


    public CarregarArquivoMockadoException(String message) {
        super(message);
    }

    public CarregarArquivoMockadoException(String message, Throwable cause) {
        super(message, cause);
    }

}
