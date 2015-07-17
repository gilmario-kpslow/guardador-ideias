package br.com.sincronizador.negocio;

import br.com.sincronizador.dao.AssuntoRepositorio;
import br.com.sincronizador.modelo.Assunto;
import br.com.webserviceideias.dao.generic.DAOEntidade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class AssuntoNegocio implements Serializable {

    @EJB
    private DAOEntidade dao;
    @EJB
    private AssuntoRepositorio repositorio;

    public Assunto salvar(Assunto assunto) {
        dao.merge(assunto);
        return assunto;
    }

    public List<Assunto> listar() {
        return repositorio.encontrarTodas();
    }
}
