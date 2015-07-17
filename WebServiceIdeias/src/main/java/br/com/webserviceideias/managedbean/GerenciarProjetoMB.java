package br.com.webserviceideias.managedbean;

/**
 *
 * @author gilmario
 */
import br.com.webserviceideias.dao.generic.IdeiaRepositorio;
import br.com.webserviceideias.modelo.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class GerenciarProjetoMB implements Serializable {

    @EJB
    private IdeiaRepositorio ideiaRepositorio;

    private Projeto projeto;
    private List ideias;

    public String selecionaProjeto(Projeto p) {
        this.projeto = p;
        ideias = ideiaRepositorio.listar(projeto, "");
        return "/web/gerenciar/projeto";
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List getIdeias() {
        return ideias;
    }

    public void setIdeias(List ideias) {
        this.ideias = ideias;
    }

}
