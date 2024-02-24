package br.com.tools.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FormaDePagamento {

    AVISTA("AVISTA"), PARCELADOEMISSOR("PARCELADO_EMISSOR"), PARCELADOLOJA("PARCELADO_LOJA");

    private final String tipo;

}
