/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.servlet;

import br.com.gilmariosoftware.webserviceideias.dao.generic.DAOEntidade;
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
@WebServlet(urlPatterns = "/ideia/criar")
public class IdeiaServlet extends HttpServlet {

    @EJB
    private DAOEntidade dao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ideiaJson = req.getParameter("ideia");
        //Ideia ideia = mapToIdeia.processa();
        //dao.persist(ideia);
        try (PrintWriter writer = resp.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            //writer.print(JsonUtilBase.mensagemJson("Ideia Registrada com sucesso!"));
            Mensagen m = new Mensagen();
            m.setNome("Ideia Registrada com sucesso!");
            String json = new Gson().toJson(m);
            writer.print(json);
        }
    }

    public class Mensagen {

        private String nome;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

    }
}
