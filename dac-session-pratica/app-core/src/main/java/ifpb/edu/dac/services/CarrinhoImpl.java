package ifpb.edu.dac.services;

import ifpb.edu.dac.ICarrinho;
import ifpb.edu.dac.domain.Cliente;
import ifpb.edu.dac.domain.Produto;
import ifpb.edu.dac.domain.Venda;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Stateful
@Remote(ICarrinho.class)
@StatefulTimeout(value = 30)
public class CarrinhoImpl implements ICarrinho<Produto, Cliente> {

    private List<Produto> produtos = new ArrayList<>();
    private Cliente cliente = null;

    public Boolean addProduto (Produto produto) {
        return produtos.add(produto);
    }

    public Boolean removeProduto (Produto produto) {
        return produtos.remove(produto);
    }

    public List<Produto> getProdutos () {
        return Collections.unmodifiableList(produtos);
    }

    public void setCliente (Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSubtotal () {
        BigDecimal subtotal = new BigDecimal("0.0");
        for (Produto p: produtos){
            subtotal = subtotal.add(p.getValor());
        }

        return subtotal;
    }

    @Remove
    public void checkout () {
        Venda venda = new Venda(produtos, cliente);
    }
}
