/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.dac.services.dao;

import ifpb.edu.dac.domain.Cliente;
import java.sql.ResultSet;
import java.util.List;

public interface InterfaceDAO {
    
    public void salvarCliente(Cliente cliente);
    public List<Cliente> listarTodos();
    public Cliente criarCliente(ResultSet result);
    
}
