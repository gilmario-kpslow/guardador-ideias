package br.com.sincronizador.validacao;

import br.com.sincronizador.validacao.excecao.ValidationExection;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gilmario
 *
 */
public abstract class ValidadorManager {

    private final List<Validador> validadores;

    public ValidadorManager(Validador... validador) {
        validadores = Arrays.asList(validador);
    }

    public void validar() throws ValidationExection {
        for (Validador v : validadores) {
            v.valida();
        }
    }

}
