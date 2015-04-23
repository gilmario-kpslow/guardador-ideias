/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.servlet;

import br.com.gilmariosoftware.webserviceideias.dao.generic.DAOEntidade;
import br.com.gilmariosoftware.webserviceideias.dao.generic.DAORepositorio;
import br.com.gilmariosoftware.webserviceideias.interfaces.Executor;
import br.com.gilmariosoftware.webserviceideias.modelo.Projeto;
import br.com.gilmariosoftware.webserviceideias.util.diversos.StringUtil;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletOutputStream;

/**
 *
 * @author gilmario
 */
public class TesteExecutor implements Executor<List, Void> {

    @EJB
    private DAORepositorio<Projeto, Integer> dao;

    @Override
    public List executar(Void... p) {
        System.out.println("OK Funcionou");

        return dao.encontrarTodas();
    }

}
