/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.dao;

import br.com.gilmariosoftware.webserviceideias.dao.generic.DAOEntidade;
import br.com.gilmariosoftware.webserviceideias.modelo.Ideia;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class IdeiaDAO extends DAOEntidade<Ideia, Long> implements Serializable {

    public IdeiaDAO() {
        super(Ideia.class);
    }

    public List<Ideia> consultarUltimasIdeias() {
        return getEntityManager().createQuery("SELECT i FROM Ideia i ORDER BY i.dataCadastro DESC").setMaxResults(10).getResultList();
    }

}
