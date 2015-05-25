/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webserviceideias.servlet;

import br.com.webserviceideias.dao.generic.DAOEntidade;
import br.com.webserviceideias.modelo.Informacao;
import br.com.webserviceideias.modelo.Projeto;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gilmario
 */
@WebServlet(urlPatterns = "/projeto/criar")
public class CriarAtualizarProjetoServlet extends HttpServlet {

    @EJB
    private DAOEntidade<Projeto> dao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        Gson g = new Gson();
        Projeto p = g.fromJson(req.getParameter("projeto"), Projeto.class);
        dao.merge(p);
        try (PrintWriter w = resp.getWriter()) {
            w.print(g.toJson(new Informacao("Registro salvo com sucesso")));
            System.out.println(g.toJson(new Informacao("Registro salvo com sucesso")));
        }
    }

}
