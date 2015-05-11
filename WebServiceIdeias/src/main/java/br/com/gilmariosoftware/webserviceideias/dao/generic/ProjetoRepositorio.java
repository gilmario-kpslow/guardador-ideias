package br.com.gilmariosoftware.webserviceideias.dao.generic;

import br.com.gilmariosoftware.webserviceideias.modelo.Projeto;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author gilmario
 */
@Stateless
public class ProjetoRepositorio extends DAORepositorio<Projeto, Long> implements Serializable {

    public ProjetoRepositorio() {
        super(Projeto.class);
    }

    public Integer contar() {
        CriteriaBuilder b = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Projeto> q = b.createQuery(Projeto.class);
        q.from(Projeto.class);
        return getEntityManager().createQuery(q).getResultList().size();
    }

}
