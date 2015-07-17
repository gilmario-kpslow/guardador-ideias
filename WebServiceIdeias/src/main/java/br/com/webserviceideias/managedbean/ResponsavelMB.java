package br.com.webserviceideias.managedbean;

import br.com.webserviceideias.modelo.Responsavel;
import br.com.webserviceideias.negocio.ResponsavelNegocio;
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
public class ResponsavelMB implements Serializable {

    @EJB
    private ResponsavelNegocio negocio;
    private Responsavel responsavel;

    @PostConstruct
    public void init() {
        responsavel = new Responsavel();
    }

    public void salvar() {
        try {
            negocio.salvar(responsavel);
            init();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro salvo com sucesso!!!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            e.printStackTrace();
        }
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

}
