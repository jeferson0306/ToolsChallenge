package br.com.tools.domain.response.wrapper;

import br.com.tools.domain.transacao.Transacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoWrapper {

    private Transacao transacao;

}
