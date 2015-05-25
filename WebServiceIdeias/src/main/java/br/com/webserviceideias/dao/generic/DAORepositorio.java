package br.com.webserviceideias.dao.generic;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gilmario
 * @param <T>
 * @param <PK>
 */
public abstract class DAORepositorio<T, PK extends Serializable> extends DAO implements Serializable {

    private final Class entidade;

    public DAORepositorio(Class entidade) {
        this.entidade = entidade;
    }

    public List encontrarTodas() {
        return getSession().createCriteria(entidade).list();
    }

    public List encontrarTodas(String campo, String nome) {
        return getSession().createCriteria(entidade).add(Restrictions.ilike(campo, nome.concat("%"))).list();
    }

    public T referencia(PK pk) {
        return (T) getSession().load(entidade, pk);
    }

    public T encontra(PK pk) {
        return (T) getSession().get(entidade, pk);
    }

    public Class getEntidade() {
        return entidade;
    }

}
