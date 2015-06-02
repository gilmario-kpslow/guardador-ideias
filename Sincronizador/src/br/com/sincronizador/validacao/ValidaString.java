package br.com.sincronizador.validacao;

import br.com.sincronizador.validacao.excecao.ValidationExection;

/**
 *
 * @author gilmario
 */
public class ValidaString implements Validador {

    private final String string;
    private final int min;
    private final int max;
    private final boolean vazia;

    public ValidaString(String string) {
        this.string = string;
        vazia = true;
        min = 0;
        max = 0;
    }

    public ValidaString(String string, int min, int max, boolean vazia) {
        this.string = string;
        this.min = min;
        this.max = max;
        this.vazia = vazia;
    }

    public boolean valida() throws ValidationExection {
        if (min > 0) {
            validaMin();
        }
        if (max > 0) {
            validaMax();
        }
        if (!vazia) {
            validaVazia();
        }
        return true;
    }

    private boolean validaMin() throws ValidationExection {
        if (string != null && string.length() < min) {
            throw new ValidationExection("O tamanho do campo dever ser maior ou igual a " + min);
        }
        return true;
    }

    private boolean validaMax() throws ValidationExection {
        if (string != null && string.length() > max) {
            throw new ValidationExection("O tamanho do campo dever ser menor ou igual a " + max);
        }
        return true;
    }

    private boolean validaVazia() throws ValidationExection {
        if (string == null || string.length() == 0) {
            throw new ValidationExection("Esse campo não pode ser vazio");
        }
        return true;

    }

}
