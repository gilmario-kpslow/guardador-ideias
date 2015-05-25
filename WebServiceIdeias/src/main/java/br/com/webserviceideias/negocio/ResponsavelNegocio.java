/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webserviceideias.negocio;

import br.com.webserviceideias.dao.generic.DAOEntidade;
import br.com.webserviceideias.modelo.Responsavel;
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
public class ResponsavelNegocio implements Serializable {

    @EJB
    private DAOEntidade dao;

    public void salvar(Responsavel r) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        r.gerahash();
        dao.merge(r);
    }

}
