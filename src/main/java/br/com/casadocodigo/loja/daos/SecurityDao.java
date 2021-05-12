package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.SystemUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SecurityDao {

    @PersistenceContext
    private EntityManager manager;

    public SystemUser findByEmail(String login) {
        return manager.createQuery("select su from SystemUser su " + "where su.login = :login", SystemUser.class)
                .setParameter("login", login)
                .getSingleResult();
    }
}
