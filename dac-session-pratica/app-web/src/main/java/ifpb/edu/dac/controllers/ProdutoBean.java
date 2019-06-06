
package ifpb.edu.dac.controllers;

import ifpb.edu.dac.domain.Produto;
import ifpb.edu.dac.services.dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProdutoBean {
    private List<Produto> produtos = new ArrayList<>();
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
    
    public List<Produto> todos() {
    	try {
			produtos = service.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return produtos;
    }
    
    public String novo() {
    	try {
			service.novo(produto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	produto = null;
    	return null;
    }
    
    public String remove(Produto p) {
    	try {
			service.remover(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public String atribuir(Produto produto) {
    	this.produto = produto;
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
