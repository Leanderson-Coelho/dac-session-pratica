/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.dac.services.dao;

import ifpb.edu.dac.domain.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ClienteDAO {
    
    void salvarCliente(Cliente cliente);
    List<Cliente> listarTodos();
    Cliente pesquisarCPF(String cpf);
    Cliente criarCliente(ResultSet result) throws SQLException;
    void remover(Cliente cliente);
    void atualizar(Cliente cliente);
}
