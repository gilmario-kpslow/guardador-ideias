package br.com.gilmariosoftware.webserviceideias.modelo;

import br.com.gilmariosoftware.webserviceideias.util.diversos.StringHashUtil;
import br.com.gilmariosoftware.webserviceideias.util.diversos.StringUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gilmario
 */
@Entity
@Table(schema = "ideia", name = "ideia")
public class Ideia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Length(min = 3, max = 50)
    @Column(nullable = false, length = 50, unique = true)
    private String titulo;
    @Length(min = 3, max = 1024)
    @NotBlank
    @Column(nullable = false, length = 1024)
    private String descricao;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar dataCadastro;
    @Column(nullable = false, length = 256)
    @NotBlank
    private String hashideia;
    @Enumerated(EnumType.STRING)
    private StatusIdeia status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Projeto projeto;

    public Ideia() {
        this.status = StatusIdeia.Aberta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = StringUtil.capitalizar(titulo);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public StatusIdeia getStatus() {
        return status;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public void gerahash() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.hashideia = StringHashUtil.criaHash(titulo.concat(status.toString()).concat(Integer.toString(this.hashCode())));
    }

    public String getHashideia() {
        return hashideia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Ideia other = (Ideia) obj;
        return !(!Objects.equals(this.id, other.id) && (this.id == null || !this.id.equals(other.id)));
    }

    public enum StatusIdeia {

        Aberta, Concluida, Cancelada, Todas
    }

}
