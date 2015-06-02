package br.com.sincronizador.validacao;

import br.com.sincronizador.modelos.Assunto;

/**
 *
 * @author gilmario
 */
public class ValidaAssunto extends ValidadorManager {

    public ValidaAssunto(Assunto assunto) {
        super(new ValidaString(assunto.getDescricao(), 3, 20, false));
    }

}
