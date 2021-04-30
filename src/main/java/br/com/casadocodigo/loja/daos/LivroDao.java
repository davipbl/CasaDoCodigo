package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LivroDao {

    @PersistenceContext
    private EntityManager manager;

    public void salvar(Livro livro) {
        manager.persist(livro);
    }

    public List<Livro> listar() {
        String jpql = "select distinct(l) from Livro l"
                + " join fetch l.autores";
        return manager.createQuery(jpql, Livro.class).getResultList();
    }
}
