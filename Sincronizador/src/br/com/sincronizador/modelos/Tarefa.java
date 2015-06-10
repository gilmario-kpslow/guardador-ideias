package br.com.sincronizador.modelos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gilmario
 */
public class Tarefa implements Serializable, IdModel {

    private Long id;
    private String titulo;
    private String descricao;
    private Date dataCadastro;
    private Date dataPrevisao;
    private Date dataInicio;
    private Date dataConclusao;
    private StatusTarefa status;
    private Assunto assunto;
    private String stringhash;

    public Tarefa() {
        dataCadastro = new Date();
        status = StatusTarefa.Pendente;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(Date dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStringhash() {
        return stringhash;
    }

    public void setStringhash(String stringhash) {
        this.stringhash = stringhash;
    }

    public enum StatusTarefa {

        Pendente, Agendada, Iniciada, Concluida, Cancelada

    }

}
