package br.com.webserviceideias.negocio;

import br.com.webserviceideias.dao.generic.DAOEntidade;
import br.com.webserviceideias.modelo.Ideia;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author gilmario
 */
@Stateful
public class IdeiaNegocio implements Serializable {

    @EJB
    private DAOEntidade dao;

    public void salvar(Ideia i) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        i.gerahash();
        i.setDataCadastro(Calendar.getInstance());
        dao.merge(i);
    }

}
