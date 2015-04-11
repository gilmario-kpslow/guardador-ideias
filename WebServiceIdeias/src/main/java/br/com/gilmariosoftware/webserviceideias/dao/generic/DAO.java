/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.dao.generic;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gilmario
 *
 */
public abstract class DAO implements Serializable {

    @PersistenceContext(unitName = "ServidorGuardadorPU")
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
