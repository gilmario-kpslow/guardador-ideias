package br.com.sincronizador.modelo;

import br.com.webserviceideias.util.diversos.StringHashUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gilmario
 */
@Entity
@Table(schema = "sincronizador")
public class Assunto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 30, min = 3)
    @NotBlank
    @Column(length = 30, nullable = false)
    private String descricao;
    @NotBlank
    @Column(nullable = false, length = 256)
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

    public void gerahash() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.stringhash = StringHashUtil.geraHashFromObjects(descricao, this.hashCode());
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
