package br.com.gilmariosoftware.webserviceideias.managedbean;

import br.com.gilmariosoftware.webserviceideias.modelo.Projeto;
import br.com.gilmariosoftware.webserviceideias.negocio.ProjetoNegocio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@ViewScoped
public class ProjetoMB implements Serializable {

    @EJB
    private ProjetoNegocio negocio;
    private Projeto projeto;

    @PostConstruct
    private void init() {
        projeto = new Projeto();
    }

    public void salvar() {
        try {
            negocio.salvar(projeto);
            init();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro salvo com sucesso!!!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            e.printStackTrace();
        }
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
