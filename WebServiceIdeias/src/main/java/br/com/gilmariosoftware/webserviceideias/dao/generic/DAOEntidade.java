/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.dao.generic;

import java.io.Serializable;

/**
 *
 * @author gilmario
 * @param <T>
 * @param <PK>
 */
public abstract class DAOEntidade<T, PK extends Serializable> extends DAO implements Serializable {

    private final Class<T> classeEntidade;

    public DAOEntidade(Class<T> classe) {
        this.classeEntidade = classe;
    }

    public void persist(T t) {
        getEntityManager().persist(t);
    }

    public T merge(T t) {
        return (T) getEntityManager().merge(t);
    }

    public T referencia(PK pk) {
        return (T) getEntityManager().getReference(classeEntidade, pk);
    }

    public T encontra(PK pk) {
        return (T) getEntityManager().find(classeEntidade, pk);
    }

}
