package br.com.gilmariosoftware.webserviceideias.dao.generic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author gilmario
 */
public class DAORepositorio<T, PK extends Serializable> extends DAO implements Serializable {

    private final Class entidade;

    public DAORepositorio(Class entidade) {
        this.entidade = entidade;
    }

    public List encontrarTodas() {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        builder.createQuery(entidade);
        return getEntityManager().createQuery(builder.createQuery()).getResultList();
    }

    public T referencia(PK pk) {
        return (T) getEntityManager().getReference(entidade, pk);
    }

    public T encontra(PK pk) {
        return (T) getEntityManager().find(entidade, pk);
    }
}
