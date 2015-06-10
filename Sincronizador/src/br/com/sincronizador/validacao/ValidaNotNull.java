package br.com.sincronizador.validacao;

import br.com.sincronizador.validacao.excecao.ValidationExection;

/**
 *
 * @author gilmario
 */
public class ValidaNotNull implements Validador {

    private final Object object;

    public ValidaNotNull(Object object) {
        this.object = object;
    }

    public boolean valida() throws ValidationExection {
        if (object == null) {
            throw new ValidationExection("Esse campo não pode ser nulo.");
        }
        return true;
    }

}
