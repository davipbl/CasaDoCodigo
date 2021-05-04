package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

// CDI
@Named
@RequestScoped // Essa anotação é a do JavaX contexto - usa-se ela, pois a do JSF não se liga bem com o CDI.
public class AdminLivrosBean {

    private Livro livro = new Livro();

    @Inject //Context and Dependency Injection
    private LivroDao dao;

    @Inject
    private AutorDao autorDao;

    @Inject
    private FacesContext context;

    private Part capaLivro;


    @Transactional
    public String salvar() throws IOException {
        dao.salvar(livro);
        FileSaver fileSaver = new FileSaver();
        livro.setCapaPath(fileSaver.write(capaLivro, "livros"));

        //Escopo de flash para enviar a mensagem da página atual para o próximo request
        context.getExternalContext().getFlash().setKeepMessages(true);

        //Adicionar mensagem para a página
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));

        return "/livros/lista?faces-redirect=true";
    }

    public List<Autor> getAutores() {
        return autorDao.listar();
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Part getCapaLivro() {
        return capaLivro;
    }

    public void setCapaLivro(Part capaLivro) {
        this.capaLivro = capaLivro;
    }
}
