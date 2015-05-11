/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.servlet;

import br.com.gilmariosoftware.webserviceideias.dao.generic.ProjetoRepositorio;
import br.com.gilmariosoftware.webserviceideias.modelo.Projeto;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gilmario
 */
@WebServlet(urlPatterns = "/teste")
public class TesteServlet extends HttpServlet {

    @Inject
    private ProjetoRepositorio pr;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Projeto p = new Projeto();
        p.setNome("Teste");
        //p.setStatus(Projeto.StatusProjeto.Parado);

        Gson g = new Gson();
        try (ServletOutputStream o = resp.getOutputStream()) {
            o.print(g.toJson(pr.encontrarTodas()));
        }
    }

}
