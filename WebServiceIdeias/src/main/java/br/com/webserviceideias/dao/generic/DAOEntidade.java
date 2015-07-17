package br.com.webserviceideias.dao.generic;

import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 * @param <T>
 */
@Stateless
public class DAOEntidade<T> extends DAO implements Serializable {

    public DAOEntidade() {

    }

    public void persist(T t) {
        //getEntityManager().persist(t);
        getSession().saveOrUpdate(t);
    }

    public T merge(T t) {
        //getEntityManager().merge(t);
        return (T) getSession().merge(t);
    }

}
