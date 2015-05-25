package br.com.webserviceideias.negocio;

import br.com.webserviceideias.dao.generic.DAOEntidade;
import br.com.webserviceideias.modelo.Projeto;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ProjetoNegocio implements Serializable {

    @EJB
    private DAOEntidade dao;

    public void salvar(Projeto p) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        p.gerahash();
        dao.merge(p);
    }

}
