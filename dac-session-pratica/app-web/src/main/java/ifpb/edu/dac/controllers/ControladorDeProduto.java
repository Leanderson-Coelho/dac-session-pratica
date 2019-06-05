/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.dac.controllers;

import ifpb.edu.dac.domain.Produto;
import ifpb.edu.dac.services.dao.ProdutoDAO;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raul Coelho
 */


@RequestScoped
@Named
public class ControladorDeProduto implements Serializable {

    private Produto produto;

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

    public String editar(Produto produto) throws SQLException {
        this.produto = produto;
        this.produtoDAO.atualizar(this.produto);
        return null;
    }

    public List<Produto> getProdutosBuscados() throws SQLException {
        return produtoDAO.buscarPorDescricao(descricaoProduto);
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
}

