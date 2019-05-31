
package ifpb.edu.dac.controllers;

import ifpb.edu.dac.domain.Produto;
import ifpb.edu.dac.services.dao.ProdutoDAO;
import ifpb.edu.dac.services.dao.ProdutoDAOImpl;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProdutoBean {
    private String buscaString;
    private List<Produto> produtos;
    private ProdutoDAO pdao = null;

    public ProdutoBean() {
    pdao = (ProdutoDAO) new ProdutoDAOImpl();
    }  
    
    public List<Produto> buscaPorDescricao(String descricao) throws SQLException{
        produtos = pdao.buscarPorDescricao(descricao);
        return produtos;
    }
    
    public String editarProduto(Produto produto) throws SQLException{
        pdao.atualizar(produto);
        return null;
    }
    

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getBuscaString() {
        return buscaString;
    }

    public void setBuscaString(String buscaString) {
        this.buscaString = buscaString;
    }

   
    
    
}
