package br.com.gilmariosoftware.webserviceideias.modelo;

import br.com.gilmariosoftware.webserviceideias.util.diversos.StringHashUtil;
import br.com.gilmariosoftware.webserviceideias.util.diversos.StringUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(schema = "ideia", name = "responsavel")
public class Responsavel implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Length(min = 2, max = 100)
    @Column(nullable = false, length = 100)
    private String nome;
    @NotBlank
    @Length(min = 8, max = 40)
    @Column(nullable = false, length = 40, unique = true)
    private String login;
    @NotBlank
    @Length(max = 255)
    @Column(nullable = false, unique = true)
    private String email;
    @Column
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;
    @NotBlank
    @Length(min = 8, max = 40)
    @Column(nullable = false, length = 40)
    private String senha;
    @Column(nullable = false, length = 256)
    @NotBlank
    private String hashprojeto;
    @OneToMany(fetch = FetchType.EAGER)
    private final List<Projeto> listaDeProjetos;

    public Responsavel() {
        listaDeProjetos = new ArrayList<>();
    }

    public void adicionaProjeto(Projeto projeto) {
        if (!listaDeProjetos.contains(projeto)) {
            listaDeProjetos.add(projeto);
        }
    }

    public void removeProjeto(Projeto projeto) {
        if (listaDeProjetos.contains(projeto)) {
            listaDeProjetos.remove(projeto);
        }
    }

    public List<Projeto> getListaDeProjetos() {
        return Collections.unmodifiableList(listaDeProjetos);
    }

    public void gerahash() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.hashprojeto = StringHashUtil.geraHash(login.concat(email).concat(Integer.toString(this.hashCode())));
    }

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
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.senha = StringHashUtil.convertMD5(senha);
    }

    public String getHashprojeto() {
        return hashprojeto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Responsavel other = (Responsavel) obj;
        return Objects.equals(this.id, other.id);
    }

}
