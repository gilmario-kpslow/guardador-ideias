/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.modelo;

import br.com.gilmariosoftware.webserviceideias.util.diversos.StringUtil;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class Categoria implements Serializable {

    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = StringUtil.capitalizar(nome);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        return !(!Objects.equals(this.id, other.id) && (this.id == null || !this.id.equals(other.id)));
    }

}
