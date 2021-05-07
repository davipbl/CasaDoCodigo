package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UsuarioDao {

    @PersistenceContext
    private EntityManager manager;

    public void salvar(Usuario usuario) {
        manager.persist(usuario);
    }
}
