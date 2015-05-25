package br.com.gilmariosoftware.webserviceideias.modelo;

import br.com.gilmariosoftware.webserviceideias.util.diversos.StringHashUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(schema = "ideia", name = "projeto")
public class Projeto implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50, unique = true)
    @NotBlank
    @Length(min = 3, max = 50)
    private String nome;
    @Column(nullable = false, length = 256)
    @NotBlank
    private String hashprojeto;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private final StatusProjeto status;

    public Projeto() {
        this.status = StatusProjeto.Parado;
    }

    public Long getId() {
        return id;
    }

    public void gerahash() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.hashprojeto = StringHashUtil.geraHash(nome.concat(status.toString()).concat(Integer.toString(this.hashCode())));
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusProjeto getStatus() {
        return status;
    }

    public String getHashprojeto() {
        return hashprojeto;
    }

    public enum StatusProjeto {

        Aguardando, Iniciado, Parado, Concluido
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Projeto other = (Projeto) obj;
        return Objects.equals(this.id, other.id);
    }

}
