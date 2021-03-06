package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model //@RequestScope e @Named
public class CarrinhoComprasBean {

    @Inject
    private LivroDao livroDao;

    @Inject
    private CarrinhoCompras carrinho;

    public String add(Integer id) {
        Livro livro = livroDao.buscarPorId(id);
        CarrinhoItem item = new CarrinhoItem(livro);
        carrinho.add(item);

        return "carrinho?faces-redirect=true";
    }

    public void remover(CarrinhoItem item) {
        carrinho.remover(item);
    }

    public List<CarrinhoItem> getItens() {
        return carrinho.getItens();
    }
}
