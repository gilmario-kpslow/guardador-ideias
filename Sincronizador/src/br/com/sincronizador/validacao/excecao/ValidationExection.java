package br.com.sincronizador.validacao.excecao;

/**
 *
 * @author gilmario
 */
public class ValidationExection extends Exception {

    public ValidationExection(String detailMessage) {
        super(detailMessage);
    }

}
