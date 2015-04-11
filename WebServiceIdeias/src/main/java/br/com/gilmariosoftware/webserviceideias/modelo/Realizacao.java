/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gilmariosoftware.webserviceideias.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gilmario
 */
@Entity
@Table(schema = "ideia", name = "realizacao")
@IdClass(Realizacao.RealizacaoPK.class)
public class Realizacao implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer codigo;
    @JoinColumn(nullable = false, referencedColumnName = "id", name = "id_ideia")
    @ManyToOne
    private Ideia idea;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusRealizacao status;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Ideia getIdea() {
        return idea;
    }

    public void setIdea(Ideia idea) {
        this.idea = idea;
    }

    public StatusRealizacao getStatus() {
        return status;
    }

    public void setStatus(StatusRealizacao status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.codigo);
        hash = 11 * hash + Objects.hashCode(this.idea);
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
        final Realizacao other = (Realizacao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.idea, other.idea);
    }

    public class RealizacaoPK implements Serializable {

        private Integer codigo;
        private Ideia idea;

        public RealizacaoPK() {
        }

        public RealizacaoPK(Integer codigo, Ideia idea) {
            this.codigo = codigo;
            this.idea = idea;
        }

        public Integer getCodigo() {
            return codigo;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }

        public Ideia getIdea() {
            return idea;
        }

        public void setIdea(Ideia idea) {
            this.idea = idea;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 53 * hash + Objects.hashCode(this.codigo);
            hash = 53 * hash + Objects.hashCode(this.idea);
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
            final RealizacaoPK other = (RealizacaoPK) obj;
            if (!Objects.equals(this.codigo, other.codigo)) {
                return false;
            }
            return Objects.equals(this.idea, other.idea);
        }
    }

    public enum StatusRealizacao {

        Aguardando, Iniciado, Parado, Concluido
    }

}
