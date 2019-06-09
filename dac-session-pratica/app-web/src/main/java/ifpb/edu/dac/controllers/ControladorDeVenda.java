package ifpb.edu.dac.controllers;

import ifpb.edu.dac.domain.Produto;
import ifpb.edu.dac.domain.Venda;
import ifpb.edu.dac.services.dao.VendaDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Raul Coelho
 */

@RequestScoped
@Named
public class ControladorDeVenda implements Serializable {

    private Venda venda;
    private List<Produto> produtos = new ArrayList<>();

    @EJB
    private VendaDAO vendasEmJDBC;


    public List<Produto> listarProdutos(){
    	try {
    		produtos = vendasEmJDBC.listarProdutos(venda);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return produtos;
    }

    public String adicionar(){
        try {
			this.vendasEmJDBC.nova(venda);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return null;
    }

    public Venda getVenda(){
        return venda;
    }

    public void setVenda(Venda venda){
        this.venda = venda;
    }

    public VendaDAO getVendasEmJDBC() {
        return vendasEmJDBC;
    }

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
    

}
