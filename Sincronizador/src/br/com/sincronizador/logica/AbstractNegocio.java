package br.com.sincronizador.logica;

import br.com.sincronizador.dao.DAO;
import br.com.sincronizador.modelos.IdModel;
import br.com.sincronizador.validacao.ValidadorManager;
import br.com.sincronizador.validacao.excecao.ValidationExection;
import java.util.List;

/**
 *
 * @author gilmario
 * @param <T>
 */
public abstract class AbstractNegocio<T extends IdModel> {

    private final DAO<T> dao;

    public AbstractNegocio(DAO<T> dao) {
        this.dao = dao;
    }

    public void salvar(T t) throws ValidationExection, Exception {
        validaEntidade(t);
        if (t.getId() == null) {
            dao.salva(t);
        } else {
            dao.update(t);
        }

    }

    protected DAO<T> getDao() {
        return dao;
    }

    public List<T> listar() {
        return getDao().listar();
    }

    private void validaEntidade(T t) throws ValidationExection {
        getValidatorManager(t).validar();
    }

    protected abstract ValidadorManager getValidatorManager(T t);
}
