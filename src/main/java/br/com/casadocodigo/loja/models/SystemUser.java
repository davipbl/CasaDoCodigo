package br.com.casadocodigo.loja.models;

import jakarta.validation.constraints.Email;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email
    private String login;

    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<SystemRole> roles = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
