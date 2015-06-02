package br.com.sincronizador.listener;

/**
 *
 * @author gilmario
 * @param <T>
 */
public interface ServiceListener<T> {

    public void process(T t);

}
