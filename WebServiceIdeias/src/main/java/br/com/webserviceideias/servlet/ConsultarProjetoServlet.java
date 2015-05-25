/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webserviceideias.servlet;

import br.com.webserviceideias.dao.generic.ProjetoRepositorio;
import com.google.gson.Gson;
import java.io.IOException;
import javax.ejb.EJB;
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
@WebServlet(urlPatterns = "/projeto/consultar")
public class ConsultarProjetoServlet extends HttpServlet {

    @EJB
    private ProjetoRepositorio pr;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        Gson g = new Gson();
        try (ServletOutputStream w = resp.getOutputStream()) {
            w.println(g.toJson(pr.encontrarTodas()));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        Gson g = new Gson();
        try (ServletOutputStream w = resp.getOutputStream()) {
            w.println(g.toJson(pr.encontrarTodas()));
        }
    }

}
