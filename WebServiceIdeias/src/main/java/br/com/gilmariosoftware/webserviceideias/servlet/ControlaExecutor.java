/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.servlet;

import br.com.gilmariosoftware.webserviceideias.interfaces.Executor;
import br.com.gilmariosoftware.webserviceideias.util.diversos.StringUtil;
import java.io.IOException;
import java.util.List;
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
@WebServlet("/projeto/*")
public class ControlaExecutor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classe = "br.com.gilmariosoftware.servlet." + StringUtil.capitalizar(req.getRequestURI().replace("\\/guardador\\/projeto\\/", ""));
        try {
            Executor<Void, Void> e = (Executor<Void, Void>) ClassLoader.getSystemClassLoader().loadClass(classe).newInstance();
            e.executar(null);
            try (ServletOutputStream out = resp.getOutputStream()) {
                out.println(classe);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classe = "br.com.gilmariosoftware.webserviceideias.servlet." + StringUtil.capitalizar(req.getRequestURI().replace("/guardador/projeto/", "")) + "Executor";

        System.out.println(this.getClass().getName());
        classe = TesteExecutor.class.getName();
        System.out.println(classe);

        try {
            //Executor<Void, Void> e = (Executor<Void, Void>) ClassLoader.getSystemClassLoader().loadClass(classe).newInstance();
            Object e = Class.forName(classe).newInstance();
            ((Executor) e).executar((Void) null);
            try (ServletOutputStream out = resp.getOutputStream()) {
                out.println(classe);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }

    }

}
