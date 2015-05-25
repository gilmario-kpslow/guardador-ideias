package br.com.gilmariosoftware.webserviceideias.dao.generic;

import br.com.gilmariosoftware.webserviceideias.modelo.Responsavel;
import br.com.gilmariosoftware.webserviceideias.modelo.Responsavel_;
import java.io.Serializable;
import javax.ejb.Stateless;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gilmario
 */
@Stateless
public class ResponsavelRepositorio extends DAORepositorio<Responsavel, Long> implements Serializable {

    public ResponsavelRepositorio() {
        super(Responsavel.class);
    }

    public Responsavel login(String login, String senha) {
        return (Responsavel) getSession().createCriteria(Responsavel.class).add(Restrictions.eq(Responsavel_.login.getName(), login)).add(Restrictions.eq(Responsavel_.senha.getName(), senha)).uniqueResult();
    }

}
