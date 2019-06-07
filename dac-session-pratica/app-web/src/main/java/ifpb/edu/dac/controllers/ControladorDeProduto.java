
package ifpb.edu.dac.controllers;
import ifpb.edu.dac.domain.Produto;
import ifpb.edu.dac.services.dao.ProdutoDAO;
import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;


@SessionScoped
@Named
public class ControladorDeProduto implements Serializable {

    private Produto produto;
    private List<Produto> produtos;
    private String descricaoProduto;

    @EJB
    private ProdutoDAO produtoDAO;

    public List<Produto> getTodosOsProdutos() throws SQLException {
        return produtoDAO.listar();
    }

    public String adicionar() throws SQLException {
        this.produtoDAO.novo(produto);
        return null;
    }

    public String remover(Produto produto) throws SQLException {
        this.produto = produto;
        this.produtoDAO.remover(this.produto);
        return null;
    }

    public String atualizar(Produto produto) throws SQLException {
        this.produtoDAO.atualizar(this.produto);
        this.produto = new Produto();
        return null;
    }
    
    public String editar(Produto produto){
        this.produto = produto;
        return "produto/edit.xhtml";
    }

    public List<Produto> buscaProdutoPorDescricao() throws SQLException{
        produtos = this.produtoDAO.buscarPorDescricao(this.descricaoProduto);
        return produtos;
    }
    

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}

