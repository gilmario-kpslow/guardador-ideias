/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.dao.generic;

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
        getEntityManager().persist(t);
    }

    public T merge(T t) {
        return (T) getEntityManager().merge(t);
    }

}
