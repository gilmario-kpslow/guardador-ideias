package br.com.sincronizador.dao;

import br.com.sincronizador.modelo.Assunto;
import br.com.sincronizador.modelo.Tarefa;
import br.com.sincronizador.modelo.Tarefa_;
import br.com.webserviceideias.dao.generic.DAORepositorio;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gilmario
 */
@Stateless
public class TarefaRepositorio extends DAORepositorio<Tarefa, Long> {

    public TarefaRepositorio() {
        super(Tarefa.class);
    }

    public List<Tarefa> getTarefas(Assunto assunto) {
        return getSession().createCriteria(getEntidade()).add(Restrictions.conjunction().add(Restrictions.eq(Tarefa_.assunto.getName(), assunto))).list();
    }

}
