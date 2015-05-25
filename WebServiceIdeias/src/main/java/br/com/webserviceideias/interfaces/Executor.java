package br.com.webserviceideias.interfaces;

/**
 * Executar Uma determinada ação
 *
 * @author gilmario
 * @param <Retorno>
 * @param <Parametro>
 */
public interface Executor<Retorno, Parametro> {

    public Retorno executar(Parametro... p);

}
