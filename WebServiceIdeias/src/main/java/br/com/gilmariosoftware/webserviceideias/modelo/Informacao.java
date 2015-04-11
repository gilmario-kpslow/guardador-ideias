/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.modelo;

/**
 *
 * @author gilmario
 */
public class Informacao {

    private String titulo;
    private String descricao;
    private TipoMensagem tipo;

    public Informacao() {
    }

    public Informacao(String descricao) {
        this.descricao = descricao;
        this.titulo = "Informação";
        this.tipo = TipoMensagem.INFORMACAO;
    }

    public Informacao(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = TipoMensagem.SUCESSO;
    }

    public Informacao(String titulo, String descricao, TipoMensagem tipo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
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

    public TipoMensagem getTipo() {
        return tipo;
    }

    public void setTipo(TipoMensagem tipo) {
        this.tipo = tipo;
    }

    protected enum TipoMensagem {

        INFORMACAO, SUCESSO, ATANCAO, ERRO, FATAL
    }
}
