package br.com.webserviceideias.managedbean;

import br.com.webserviceideias.modelo.Ideia;
import br.com.webserviceideias.negocio.IdeiaNegocio;
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
public class IdeiaMB implements Serializable {

    @EJB
    private IdeiaNegocio negocio;
    private Ideia ideia;

    @PostConstruct
    private void init() {
        ideia = new Ideia();
    }

    public void salvar() {
        try {
            negocio.salvar(ideia);
            init();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro salvo com sucesso!!!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            e.printStackTrace();
        }
    }

    public Ideia getIdeia() {
        return ideia;
    }

    public void setIdeia(Ideia ideia) {
        this.ideia = ideia;
    }

}
