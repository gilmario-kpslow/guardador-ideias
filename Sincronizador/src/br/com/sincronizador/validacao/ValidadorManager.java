package br.com.sincronizador.validacao;

import br.com.sincronizador.validacao.excecao.ValidationExection;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class ValidadorManager {

    private final List<Validador> validadores;

    public ValidadorManager(Validador... validador) {
        validadores = Arrays.asList(validador);
    }

    public boolean validar() throws ValidationExection {
        boolean valido = false;
        for (Validador v : validadores) {
            valido = v.valida();
            if (!valido) {
                break;
            }
        }
        return valido;
    }

}
