/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.servlet;

import br.com.gilmariosoftware.webserviceideias.dao.generic.DAORepositorio;
import br.com.gilmariosoftware.webserviceideias.modelo.Ideia;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(asyncSupported = true, urlPatterns = "/ideia/ultimas")
public class ConsultaIdeiaServlet extends HttpServlet {

    //@EJB
    //private DAORepositorio<Ideia, Integer> dao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter w = resp.getWriter()) {
            //w.print(new Gson().toJson(dao.encontrarTodas()));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter w = resp.getWriter()) {
            //    w.print(new Gson().toJson(dao.encontrarTodas()));
        }
    }

}
