package br.com.gilmariosoftware.webserviceideias.managedbean;

import br.com.gilmariosoftware.webserviceideias.dao.generic.IdeiaRepositorio;
import br.com.gilmariosoftware.webserviceideias.modelo.Ideia;
import br.com.gilmariosoftware.webserviceideias.modelo.Projeto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class IdeiaConsultaMB implements Serializable {

    @EJB
    private IdeiaRepositorio repositorio;
    private List<Ideia> listaDeIdeias;
    private String nome;
    private Projeto projeto;

    @PostConstruct
    public void init() {
        listaDeIdeias = new ArrayList<>();
        nome = "";

    }

    public void consultar() {
        listaDeIdeias = repositorio.listar(projeto, nome);
        if (listaDeIdeias.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Nenhum resultado encontrado!"));
        }
    }

    public List<Ideia> getListaDeIdeias() {
        return listaDeIdeias;
    }

    public void setListaDeIdeias(List<Ideia> listaDeIdeias) {
        this.listaDeIdeias = listaDeIdeias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
