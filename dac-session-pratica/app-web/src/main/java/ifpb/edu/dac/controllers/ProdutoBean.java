
package ifpb.edu.dac.controllers;

import ifpb.edu.dac.domain.Produto;
import ifpb.edu.dac.services.dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProdutoBean {
    private List<Produto> produtos;
    private Produto produto;
    private String descricao;
    
    @EJB
    private ProdutoDAO service;
    
    public String buscaPorDescricao(){
    	try {
			produtos = service.buscarPorDescricao(descricao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public String editarProduto(){
        try {
			service.atualizar(produto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public String todos() {
    	try {
			produtos = service.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public String novo() {
    	try {
			service.novo(produto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public String remove() {
    	try {
			service.remover(produto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public String atualizar() {
    	try {
			service.atualizar(produto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
