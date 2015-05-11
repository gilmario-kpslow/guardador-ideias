/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.negocio;

import br.com.gilmariosoftware.webserviceideias.dao.generic.DAOEntidade;
import br.com.gilmariosoftware.webserviceideias.modelo.Projeto;
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