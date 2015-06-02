package br.com.sincronizador.modelos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class Assunto implements Serializable {

    private Long id;
    private String descricao;
    private String stringhash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStringhash() {
        return stringhash;
    }

    public void setStringhash(String stringhash) {
        this.stringhash = stringhash;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Assunto other = (Assunto) obj;
        return Objects.equals(this.id, other.id);
    }

}
