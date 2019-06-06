package ifpb.edu.dac.controllers;

import ifpb.edu.dac.ICarrinho;
import ifpb.edu.dac.domain.Produto;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Raul Coelho
 */

@SessionScoped
@Named
public class ControladorDeCarrinho implements Serializable {

    private Produto produto;

    @EJB
    private ICarrinho carrinho;

    public String adicionar(){
        this.carrinho.addProduto(produto);
        return null;
    }

    public List<Produto> getProdutos(){
        return this.carrinho.getProdutos();
    }

    public String remover(){
        this.carrinho.removeProduto(produto);
        return null;
    }

    public void finalizarSessao(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
    }

    public String finalizar(){
        this.carrinho.checkout();
        finalizarSessao();
        return "carinho.xhtml?faces-redirect=true";

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ICarrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ICarrinho carrinho) {
        this.carrinho = carrinho;
    }
}
