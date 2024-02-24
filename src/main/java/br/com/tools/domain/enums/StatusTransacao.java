package br.com.tools.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusTransacao {

    AUTORIZADO("AUTORIZADO"), NEGADO("NEGADO"), CANCELADO("CANCELADO");

    private final String status;

}
