package br.com.sincronizador.dao;

import br.com.sincronizador.modelo.Assunto;
import br.com.webserviceideias.dao.generic.DAORepositorio;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class AssuntoRepositorio extends DAORepositorio<Assunto, Long> {

    public AssuntoRepositorio() {
        super(Assunto.class);
    }

}
