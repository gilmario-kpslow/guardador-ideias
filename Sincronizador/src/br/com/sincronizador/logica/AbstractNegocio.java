package br.com.sincronizador.logica;

import br.com.sincronizador.dao.DAO;
import br.com.sincronizador.validacao.excecao.ValidationExection;

/**
 *
 * @author gilmario
 * @param <T>
 */
public abstract class AbstractNegocio<T> {

    private final DAO<T> dao;

    public AbstractNegocio(DAO<T> dao) {
        this.dao = dao;
    }

    public boolean salvar(T t) throws ValidationExection {
        if (validaEntidade(t)) {
            dao.salva(t);
        }
        return true;
    }

    public DAO<T> getDao() {
        return dao;
    }

    protected abstract boolean validaEntidade(T t) throws ValidationExection;

}
