package br.com.gilmariosoftware.webserviceideias.dao.generic;

import br.com.gilmariosoftware.webserviceideias.modelo.Ideia;
import br.com.gilmariosoftware.webserviceideias.modelo.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gilmario
 */
@Stateless
public class IdeiaRepositorio extends DAORepositorio<Ideia, Long> implements Serializable {

    public IdeiaRepositorio() {
        super(Ideia.class);
    }

    public List<Ideia> listar(Projeto p, String nome) {
        Criteria criteria = getSession().createCriteria(getEntidade()).add(Restrictions.ilike("titulo", nome.concat("%")));
        if (p != null) {
            criteria.add(Restrictions.conjunction().add(Restrictions.eq("projeto", p)));
        }
        return criteria.list();
    }

}
