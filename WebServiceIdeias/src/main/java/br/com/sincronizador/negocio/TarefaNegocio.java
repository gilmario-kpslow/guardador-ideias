package br.com.sincronizador.negocio;

import br.com.sincronizador.dao.TarefaRepositorio;
import br.com.sincronizador.modelo.Tarefa;
import br.com.webserviceideias.dao.generic.DAOEntidade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class TarefaNegocio implements Serializable {

    @EJB
    private DAOEntidade<Tarefa> dao;
    @EJB
    private TarefaRepositorio repositorio;

    public Tarefa salvar(Tarefa tarefa) {
        dao.merge(tarefa);
        return tarefa;
    }

}
