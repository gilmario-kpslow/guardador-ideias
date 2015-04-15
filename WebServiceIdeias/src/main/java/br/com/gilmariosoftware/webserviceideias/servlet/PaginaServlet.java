/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gilmario
 */
@WebServlet(urlPatterns = "/pagina", asyncSupported = true)
public class PaginaServlet extends HttpServlet {

    private static final String PAGINA = "pagina";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html;charset=UTF-8");
        final AsyncContext context = req.startAsync();
        context.start(() -> {
            PrintWriter w = null;
            try {
                String pagina = context.getRequest().getParameter(PAGINA);
                String real = ((ServletRequest) req).getServletContext().getRealPath("WEB-INF");
                File f = new File(real + "/paginas/" + pagina + ".html");
                FileReader reader = new FileReader(f);
                BufferedReader br = new BufferedReader(reader);
                w = resp.getWriter();
                while (br.ready()) {
                    w.print(br.readLine());
                }
                w.close();
                context.complete();
            } catch (IOException ex) {
                Logger.getLogger(PaginaServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                w.close();
            }

        });

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //final AsyncContext context = req.getAsyncContext();
        String real = ((ServletRequest) req).getServletContext().getRealPath("WEB-INF");
        File f = new File(real + "/paginas/" + "inicio" + ".html");
        FileReader reader = new FileReader(f);
        BufferedReader br = new BufferedReader(reader);
        PrintWriter w = resp.getWriter();
        //w.print(real);
        while (br.ready()) {
            w.print(br.readLine());
        }
        w.close();
        //req.getRequestDispatcher("WEB-INF/paginas/" + "inicio" + ".html").forward(req, resp);
    }

}
