package br.com.webserviceideias.managedbean;

import br.com.webserviceideias.dao.generic.ProjetoRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@ViewScoped
public class DashboardMB implements Serializable {

    @EJB
    private ProjetoRepositorio repositorio;
    private List projetos;

    @PostConstruct
    protected void init() {
        projetos = repositorio.encontrarTodas();
    }

    public List getProjetos() {
        return projetos;
    }

    public void setProjetos(List projetos) {
        this.projetos = projetos;
    }

}
