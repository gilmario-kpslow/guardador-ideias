package br.com.gilmariosoftware.webserviceideias.managedbean;

import br.com.gilmariosoftware.webserviceideias.dao.generic.ProjetoRepositorio;
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
public class ProjetoConsultaMB implements Serializable {

    @EJB
    private ProjetoRepositorio repositorio;
    private List<Projeto> listaDeProjetos;
    private String nome;

    @PostConstruct
    public void init() {
        listaDeProjetos = new ArrayList<>();
        nome = "";
    }

    public void consultar() {
        listaDeProjetos = repositorio.encontrarTodas("nome", nome);
        if (listaDeProjetos.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Nenhum resultado encontrado!"));
        }
    }

    public List<Projeto> getListaDeProjetos() {
        return listaDeProjetos;
    }

    public void setListaDeProjetos(List<Projeto> listaDeProjetos) {
        this.listaDeProjetos = listaDeProjetos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
