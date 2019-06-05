package ifpb.edu.dac.controllers;

import ifpb.edu.dac.domain.Venda;
import ifpb.edu.dac.services.dao.VendaDAO;
import java.io.Serializable;
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

    @EJB
    private VendaDAO vendasEmJDBC;


    public List<Venda> getTodasVendas(){
        return vendasEmJDBC.listar();
    }

    public String adicionar(){
        this.vendasEmJDBC.adicionar(venda);
        return null;
    }

    public String remove(Venda venda){
        this.vendasEmJDBC.remover(venda);
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

}
