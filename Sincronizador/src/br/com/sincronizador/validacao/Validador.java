package br.com.sincronizador.validacao;

import br.com.sincronizador.validacao.excecao.ValidationExection;

/**
 *
 * @author gilmario
 */
public interface Validador {

    public boolean valida() throws ValidationExection;
}
