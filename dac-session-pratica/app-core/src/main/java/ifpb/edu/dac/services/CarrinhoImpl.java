package ifpb.edu.dac.services;

import ifpb.edu.dac.Carrinho;
import ifpb.edu.dac.domain.Produto;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Stateful
@Remote(Carrinho.class)
@StatefulTimeout(value = 30)
public class CarrinhoImpl implements Carrinho<Produto> {
    private List<Produto> produtos = new ArrayList<>();

    public Boolean add(Produto produto) {
        return produtos.add(produto);
    }

    public Boolean remove(Produto produto) {
        return produtos.remove(produto);
    }

    public List<Produto> getAll () {
        return Collections.unmodifiableList(produtos);
    }
}
