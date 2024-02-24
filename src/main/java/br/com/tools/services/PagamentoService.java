package br.com.tools.services;

import br.com.tools.domain.dtos.PagamentoDTO;
import br.com.tools.domain.exception.PagamentoException;
import br.com.tools.domain.response.PagamentoResponse;
import br.com.tools.domain.transacao.Descricao;
import br.com.tools.domain.transacao.FormaPagamento;
import br.com.tools.domain.transacao.Transacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

import static br.com.tools.domain.enums.StatusTransacao.AUTORIZADO;
import static br.com.tools.domain.enums.StatusTransacao.NEGADO;
import static java.util.UUID.randomUUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final ArquivoService arquivoService;

    public PagamentoResponse processarPagamento(final PagamentoDTO pagamentoDTO) {
        try {
            log.info("iniciando o processamento do pagamento dos dados: {} para o id: {}", pagamentoDTO, pagamentoDTO.transacao().id());

            log.info("inicia a validacao do cartao: {}", pagamentoDTO.transacao().cartao());
            final var isCartaoValido = validarCartao(pagamentoDTO.transacao().cartao());
            final var status = isCartaoValido ? AUTORIZADO : NEGADO;
            log.info("finaliza a validacao do cartao: {} com o status: {}", pagamentoDTO.transacao().cartao(), status);

            log.info("inicia a geracao do codigo nsu e do codigo de autorizacao");
            final var nsu = gerarNSU();
            final var codigoAutorizacao = gerarCodigoAutorizacao();
            log.info("finaliza a geracao do codigo nsu: {} e do codigo de autorizacao: {}", nsu, codigoAutorizacao);

            log.info("iniciando o enriquecimento da pagamentoDTO de pagamento com os dados gerados: nsu: {} e codigo de autorizacao: {}", nsu, codigoAutorizacao);
            final var descricao = new Descricao(pagamentoDTO.transacao().descricao().valor(), pagamentoDTO.transacao().descricao().dataHora(), pagamentoDTO.transacao().descricao().estabelecimento(), nsu, codigoAutorizacao, status);
            final var formaPagamento = new FormaPagamento(pagamentoDTO.transacao().formaPagamento().tipo(), pagamentoDTO.transacao().formaPagamento().parcelas());
            final var transacaoPagamentoProcessada = new Transacao(pagamentoDTO.transacao().cartao(), pagamentoDTO.transacao().id(), descricao, formaPagamento);
            log.info("finalizando o enriquecimento da pagamentoDTO de pagamento com os dados: {}", transacaoPagamentoProcessada);

            log.info("finalizando o processamento do pagamento dos dados: {} para o id: {}", transacaoPagamentoProcessada, pagamentoDTO.transacao().id());

            arquivoService.salvarTransacaoNoArquivo(transacaoPagamentoProcessada);
            return new PagamentoResponse((transacaoPagamentoProcessada));
        } catch (URISyntaxException e) {
            log.error("Erro ao processar pagamento para o id {}", pagamentoDTO.transacao().id(), e);
            throw new PagamentoException("Erro ao processar pagamento para o id {} com o erro: " + pagamentoDTO.transacao().id());
        }
    }

    private boolean validarCartao(final String cartao) {
        log.info("iniciando a validacao do cartao: {}", cartao);
        final var cartaoValido = cartao != null && cartao.length() >= 16 && cartao.length() < 19;
        log.info("finalizando a validacao do cartao: {} com o retorno: {}", cartao, cartaoValido);
        return cartaoValido;
    }

    private String gerarNSU() {
        log.info("iniciando da geracao de NSU");
        final var nsu = randomUUID().toString().substring(0, 10);
        log.info("finalizando geracao de NSU com valor {}", nsu);
        return nsu;
    }

    private String gerarCodigoAutorizacao() {
        log.info("iniciando da geracao de codigo de autorizacao");
        final var codigoAutorizacao = randomUUID().toString().substring(0, 9);
        log.info("finalizando geracao de codigo de autorizacao com valor {}", codigoAutorizacao);
        return codigoAutorizacao;
    }

}
